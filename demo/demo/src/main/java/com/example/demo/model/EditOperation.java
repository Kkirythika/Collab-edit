package com.example.demo.model;

public class EditOperation {
    private String type;
    private String documentId;
    private String userId;
    private int position;
    private String text;
    private long timestamp;

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getDocumentId() { return documentId; }
    public void setDocumentId(String documentId) { this.documentId = documentId; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public int getPosition() { return position; }
    public void setPosition(int position) { this.position = position; }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }

    public long getTimestamp() { return timestamp; }
    public void setTimestamp(long timestamp) { this.timestamp = timestamp; }
}
