package com.example.demo.controller;


import com.example.demo.model.EditOperation;
import com.example.demo.service.OTEngine;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class EditorController {

    private String documentState = "";
    private final OTEngine otEngine = new OTEngine();

    @MessageMapping("/edit")
    @SendTo("/editor/updates")
    public EditOperation handleEdit(EditOperation op) {
        documentState = otEngine.applyOperation(documentState, op);
        return op;
    }

    @MessageMapping("/loadDoc")
    @SendTo("/editor/state")
    public String loadDocument(String docId) {
        return documentState;
    }
}
