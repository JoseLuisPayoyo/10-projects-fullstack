package com.payoyo.task_tracker_backend.services;

import java.util.List;

import com.payoyo.task_tracker_backend.dto.task.TaskRequest;
import com.payoyo.task_tracker_backend.dto.task.TaskResponse;

/*
 * Servicio de gestion de tareas
 */
public interface ITaskService {
    
    /*
     * Crear nueva tarea
     * @param TareaRequest datos de la tarea
     * @return Tarea creada
     */
    TaskResponse createTask(TaskRequest request);

    /*
     * Actualizar tarea
     * @param TareaRequest datos de la tarea
     * @param ID id de la tarea a actualizar
     * @return Tarea actualizada
     */
    TaskResponse updateTask(Long id, TaskRequest request);

    /*
     * Eliminar tarea
     * @param ID id de la tarea 
     */
    void deleteTask(Long id);

    /*
     * Listar todas las tareas
     * @return Lista de las tareas
     */
    List<TaskResponse> getTasks();

    /*
     * Listar tarea por id
     * @param ID id de la tarea a listar
     * @return Tarea
     */
    TaskResponse getTaskById(Long id);
}
