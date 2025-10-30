package com.payoyo.task_tracker_simple;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/task")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;
    
    /*
     * POST /api/task
     * Crear una nueva tarea
     */
    @PostMapping
    public Task create(@Valid @RequestBody Task task) {
        return taskService.create(task);
    }

    /*
     * GET /api/task
     * Listar todas las tareas
     */
    @GetMapping
    public List<Task> getAll(){
        return taskService.getAll();
    }

    /*
     * GET /api/task/{id}
     * Listar tareas por id
     */
    @GetMapping("/{id}")
    public Task findById(@PathVariable Long id) {
        return taskService.getById(id);
    }

    /*
     * PUT /api/task/{id}
     * Actualizar tarea
     */
    @PutMapping("/{id}")
    public Task update(
        @PathVariable Long id,
        @Valid @RequestBody Task task
    ) {
        return taskService.update(id, task);
    }

    /*
     * DELETE /api/task/{id}
     * Eliminar trea por id
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        taskService.delete(id);
    }
}
