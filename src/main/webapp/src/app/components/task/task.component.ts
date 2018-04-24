import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Task } from '../../types/Task';

@Component({
  selector: 'app-task',
  templateUrl: './task.component.html',
  styleUrls: ['./task.component.css']
})
export class TaskComponent implements OnInit {

  @Input()
  public task: Task;

  @Output()
  public delete = new EventEmitter<Task>();

  @Output()
  public update = new EventEmitter<Task>();

  constructor() { }

  ngOnInit() {
  }

  public updateTask(): void {
    this.task.done = !this.task.done;
    this.update.emit(this.task);
  }

  public deleteTask(): void {
    this.delete.emit(this.task);
  }

  public taskStyle(): {} {
    return {
      'border-left': (this.task.done ? 'green' : 'red') + ' 6px solid'
    };
  }
}
