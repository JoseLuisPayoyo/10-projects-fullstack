package com.payoyo.task_tracker_backend.util;

import java.time.format.DateTimeFormatter;
import java.util.Locale.Category;

import org.springframework.stereotype.Component;

import com.payoyo.task_tracker_backend.dto.task.TaskRequest;
import com.payoyo.task_tracker_backend.models.Task;

@Component
public class TaskMapper {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE_TIME; 
    
    /*
     * Convertir dto a entidad
     * @param dto
     * @return entidad
     */
    
}
