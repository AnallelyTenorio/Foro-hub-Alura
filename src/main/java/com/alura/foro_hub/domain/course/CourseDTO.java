package com.alura.foro_hub.domain.course;

import jakarta.validation.constraints.NotBlank;

public class CourseDTO {
    @NotBlank
    private String name;

    @NotBlank
    private String category;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
