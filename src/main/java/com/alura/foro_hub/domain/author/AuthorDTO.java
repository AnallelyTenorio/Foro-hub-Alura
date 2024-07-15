package com.alura.foro_hub.domain.author;

import jakarta.validation.constraints.NotBlank;

public class AuthorDTO {

    @NotBlank
    private String name;

    @NotBlank
    private String email;
}
