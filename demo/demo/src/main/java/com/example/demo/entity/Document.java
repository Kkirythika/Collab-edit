package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "document")
public class Document {

    @Id
    private Long id;

    private String content;

    public Document() {}

    public Document(Long id, String content) {
        this.id = id;
        this.content = content;
    }

    // ✅ Getters
    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    // ✅ Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }
}