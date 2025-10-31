package com.payoyo.task_tracker_backend.util;


import org.springframework.stereotype.Component;

import com.payoyo.task_tracker_backend.dto.task.TaskRequest;
import com.payoyo.task_tracker_backend.dto.task.TaskResponse;
import com.payoyo.task_tracker_backend.models.Category;
import com.payoyo.task_tracker_backend.models.Task;

@Component
public class TaskMapper {
    
    /*
     * Convertir dto a entidad
     * @param dto
     * @return entidad
     */
    public static Task toEntity(TaskRequest request, Category category) {
        Task task = new Task();

        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setPriority(request.getPriority());
        task.setCategory(category);
        task.setCompleted(false);

        return task;
    }

    /*
     * Convertir entidad a dto
     * @param entity
     * @return dto
     */
    public static TaskResponse toResponse(Task task) {
        return TaskResponse.builder()
            .id(task.getId())
            .title(task.getTitle())
            .description(task.getDescription())
            .priority(task.getPriority() != null ? task.getPriority().name() : null)
            .completed(task.isCompleted())
            .createdAt(task.getCreatedAt())
            .categoryId(task.getCategory().getId())
            .build();
    }
    
}
