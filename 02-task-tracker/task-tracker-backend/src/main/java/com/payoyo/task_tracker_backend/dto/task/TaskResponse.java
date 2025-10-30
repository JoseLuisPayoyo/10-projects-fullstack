package com.payoyo.task_tracker_backend.dto.task;

import java.time.LocalDateTime;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskResponse {
    
    private Long id;
    private String title;
    private String description;
    private String priority; 
    private boolean completed;
    private LocalDateTime createdAt;
    private Long categoryId;

}
