package com.payoyo.task_tracker_backend.util;

import org.springframework.stereotype.Component;

import com.payoyo.task_tracker_backend.dto.category.CategoryRequest;
import com.payoyo.task_tracker_backend.dto.category.CategoryResponse;
import com.payoyo.task_tracker_backend.models.Category;

@Component
public class CategoryMapper {
    
    /*
     * Convertir categoria a entidad
     * @param dto
     * @return entidad
     */
    public static Category toEntity(CategoryRequest dto) {
        Category category = new Category();
        category.setName(dto.getName());
        category.setDescription(dto.getDescription());
        return category;
    }

    /*
     * Convertir entidad a categoria
     * @param entidad
     * @return dto
     */
    public static CategoryResponse toDTO(Category category) {
        CategoryResponse dto = new CategoryResponse();
        dto.setId(category.getId());
        dto.setName(category.getName());
        dto.setDescription(category.getDescription());
        return dto;
    }
}
