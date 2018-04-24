import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Task } from '../../types/Task';
import { TaskService } from '../../services/task.service';
import { IdentityService } from '../../services/identity.service';

@Component({
  selector: 'app-section',
  templateUrl: './section.component.html',
  styleUrls: ['./section.component.css']
})
export class SectionComponent implements OnInit {

  @Input()
  public tasks: Task[];

  @Input()
  public title: string;

  @Output()
  public updateSections = new EventEmitter<void>();

  constructor(private taskService: TaskService, private identity: IdentityService) { }

  public updateTask(task: Task): void {
    this.taskService.update(task).subscribe(data => {
      this.updateSections.emit(null);
    });
  }

  public deleteTask(task: Task): void {
    this.taskService.delete(task.id).subscribe(data => {
      this.identity.getUser().tasks = this.identity.getUser().tasks.filter((t) => t.id !== task.id);
      this.tasks = this.tasks.filter((t) => t.id !== task.id);
    });
  }

  ngOnInit() {
  }

}
