package com.example.demo.service;

import com.example.demo.model.EditOperation;

public class OTEngine {

    // Apply operation directly to document state
    public String applyOperation(String doc, EditOperation op) {
        switch (op.getType()) {
            case "insert":
                return doc.substring(0, op.getPosition()) +
                       op.getText() +
                       doc.substring(op.getPosition());
            case "delete":
                return doc.substring(0, op.getPosition()) +
                       doc.substring(op.getPosition() + op.getText().length());
            default:
                return doc;
        }
    }

    // Transform two concurrent operations so they don’t conflict
    public EditOperation transform(EditOperation incoming, EditOperation existing) {
        if (incoming.getType().equals("insert") && existing.getType().equals("insert")) {
            if (incoming.getPosition() <= existing.getPosition()) {
                existing.setPosition(existing.getPosition() + incoming.getText().length());
            } else {
                incoming.setPosition(incoming.getPosition() + existing.getText().length());
            }
        } else if (incoming.getType().equals("delete") && existing.getType().equals("insert")) {
            if (incoming.getPosition() < existing.getPosition()) {
                existing.setPosition(existing.getPosition() - incoming.getText().length());
            }
        } else if (incoming.getType().equals("insert") && existing.getType().equals("delete")) {
            if (incoming.getPosition() <= existing.getPosition()) {
                existing.setPosition(existing.getPosition() + incoming.getText().length());
            }
        } else if (incoming.getType().equals("delete") && existing.getType().equals("delete")) {
            if (incoming.getPosition() < existing.getPosition()) {
                existing.setPosition(existing.getPosition() - incoming.getText().length());
            }
        }
        return existing;
    }
}
