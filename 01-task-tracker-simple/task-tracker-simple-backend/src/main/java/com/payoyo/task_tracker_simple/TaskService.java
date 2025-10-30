package com.payoyo.task_tracker_simple;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaskService {
    
    private final TaskRepository taskRepository;

    public Task create(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    public Task getById(Long id) {
        Task task = taskRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Tarea no encontrada"));
        
        return task;
    }

    public Task update(Long id, Task task) {
        Task existingTask = taskRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Tarea no encontrada"));
        
        existingTask.setTitle(task.getTitle());
        existingTask.setDescription(task.getDescription());
        existingTask.setCompleted(task.getCompleted());

        return taskRepository.save(existingTask);
    }

    public void delete(Long id) {
        taskRepository.deleteById(id);
    }

}
