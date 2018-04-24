import { Role } from './Role';
import { Task } from './Task';

export class User {

    public id: string;
    public username: string;
    public password: string;
    public roles: Role[];
    public tasks: Task[];

}
