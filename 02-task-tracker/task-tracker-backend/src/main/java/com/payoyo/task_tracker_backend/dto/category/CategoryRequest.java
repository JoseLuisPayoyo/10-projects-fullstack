package com.payoyo.task_tracker_backend.dto.category;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class CategoryRequest {

    @NotBlank(message = "La categoria es obligatoria")
    private String name;

    @Size(min = 1, max = 255, message = "La descripcion debe tener 1-255 caracteres")
    private String description;

    private List<Long> taskIds;
    
}
