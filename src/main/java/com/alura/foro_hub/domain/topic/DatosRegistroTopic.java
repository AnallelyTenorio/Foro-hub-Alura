package com.alura.foro_hub.domain.topic;

import com.alura.foro_hub.domain.author.Author;
import com.alura.foro_hub.domain.course.Course;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class DatosRegistroTopic {
    @NotBlank
    private String title;

    @NotBlank
    private String message;

    @NotNull
    @Valid
    private Author author;

    @NotNull
    @Valid
    private Course course;

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

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
