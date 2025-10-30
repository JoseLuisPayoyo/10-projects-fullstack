import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { Task } from '../task';

@Component({
  selector: 'task-list',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './task-list.html'
})

export class TaskList implements OnInit{

  tasks: Task[] = [];
  newTask = {title: '', description: ''};
  loading = false;
  error: string |null = null;

  constructor(private taskService: Task) {}

  ngOnInit(): void {
    this.load();
  }

  load(): void {
    this.loading = true;
    this.taskService.getAll().subscribe({
      next: data => {this.tasks = data; this.loading = false; },
      error: () => {this.error = 'Error cargando tareas'; this.loading = false; }
    });
  }

  add(): void {
    const title = this.newTask.title.trim();
    if(!title) return;
    this.taskService.create({ title, description: this.newTask.description?.trim() ||undefined})
      .subscribe({
        next: created => {
          this.tasks.unshift(created);
          this.newTask = {title: '', description: ''};
        },
        error: () => this.error = 'Error creando tarea'
      });
  }

  toggle(task: Task): void {
    const next = { ...task, completed: !task.completed };
    this.taskService.update(task.id, task).subscribe({
      next: updated => Object.assign(task, updated),
      error: () => this.error = 'Error actualizando tarea'
    });
  }

  remove(task: Task): void {
    this.taskService.delete(task.id).subscribe({
      next: () => this.tasks = this.tasks.filter(t => t.id !== task.id),
      error: () => this.error = 'Error eliminando tarea'
    });
  }

}
