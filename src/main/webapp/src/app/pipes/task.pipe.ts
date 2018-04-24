import { Pipe, PipeTransform } from '@angular/core';
import { Task } from '../types/Task';
import { User } from '../types/User';

@Pipe({
  name: 'taskDone'
})
export class TaskPipe implements PipeTransform {

  /**
   * Will return only the tasks done/undone
   *
   * @param {Task} value
   * @param {boolean} taskDone
   * @returns {*}
   * @memberof TaskPipe
   */
  transform(value: Task[], taskDone: boolean): any {
    return value ? value.filter((task) => task.done === taskDone) : [];
  }

}
