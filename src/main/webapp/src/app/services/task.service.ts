import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';
import { Task } from '../types/Task';

@Injectable()
export class TaskService {

  constructor(private httpClient: HttpClient) { }

  public create(task: Task): Observable<Task | null> {
    return this.httpClient.post<Task | null>(environment.baseUrl + 'task/', task);
  }

  public update(task: Task): Observable<Task | null> {
    return this.httpClient.put<Task | null>(environment.baseUrl + 'task/', task);
  }

  public delete(id: string): Observable<Task | null> {
    return this.httpClient.delete<Task | null>(environment.baseUrl + 'task/' + id);
  }
}
