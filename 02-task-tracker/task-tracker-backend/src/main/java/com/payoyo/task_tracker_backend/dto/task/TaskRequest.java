package com.payoyo.task_tracker_backend.dto.task;


import com.payoyo.task_tracker_backend.models.enums.Priority;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskRequest {
    
    @NotBlank(message = "El título es obligatorio")
    @Size(min = 1, max = 255, message = "El título debe contener entre 1 y 255 caracteres")
    private String title;

    @Size(max = 255, message = "La descripción debe contener como máximo 255 caracteres")
    private String description;

    @NotNull(message = "La prioridad es obligatoria")
    private Priority priority;

    @Builder.Default
    private boolean completed = false;

    @NotNull(message = "La categoría es obligatoria")
    private Long categoryId;

}
