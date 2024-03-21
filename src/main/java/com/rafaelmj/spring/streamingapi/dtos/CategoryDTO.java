package com.rafaelmj.spring.streamingapi.dtos;

import com.rafaelmj.spring.streamingapi.models.CategoryModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CategoryDTO(
        @NotBlank String cat_nome,
        @NotNull String cat_descricao) {
}
