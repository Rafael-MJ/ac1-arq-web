package com.rafaelmj.spring.streamingapi.dtos;

import com.rafaelmj.spring.streamingapi.models.CategoryModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record ProductDTO(
        @NotBlank String prod_nome,
        @NotNull int prod_qtd,
        @NotNull UUID id_categoria) {
}
