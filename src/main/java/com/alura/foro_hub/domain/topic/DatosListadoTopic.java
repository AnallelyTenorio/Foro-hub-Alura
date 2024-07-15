package com.alura.foro_hub.domain.topic;

import java.time.LocalDateTime;

public class DatosListadoTopic {
    private String title;
    private String message;
    private LocalDateTime creationDate;
    private String status;
    private String authorName;
    private String courseName;

    public DatosListadoTopic(String title, String message,LocalDateTime creationDate, String status, String authorName, String courseName){
        this.title = title;
        this.message = message;
        this.creationDate = creationDate;
        this.status = status;
        this.authorName = authorName;
        this.courseName = courseName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
