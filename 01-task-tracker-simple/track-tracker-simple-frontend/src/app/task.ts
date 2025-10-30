import { Injectable } from '@angular/core';
import { environment } from '../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Task {
  id: number,
  title: string,
  description?: string,
  completed: boolean;
  createdAt: string; //ISO
}

@Injectable({
  providedIn: 'root',
})

export class Task {
  
  private apiUrl = `${environment.baseUrl}`;

  constructor(private http: HttpClient) {}

  getAll(): Observable<Task[]> {
    return this.http.get<Task[]>(this.apiUrl);
  }

  create(task: {
    title: string; 
    description?: string
  }): Observable<Task> {
    return this.http.post<Task>(this.apiUrl, task);
  }

  update(id:number, task: Task): Observable<Task> {
    return this.http.put<Task>(`${this.apiUrl}/${id}`, task);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`)
  }
}
