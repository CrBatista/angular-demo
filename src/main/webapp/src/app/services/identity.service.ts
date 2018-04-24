import { Injectable } from '@angular/core';
import { User } from '../types/User';

@Injectable()
export class IdentityService {

  private loggedUser: User;

  constructor() { }

  public doLogin(user: User): void {
    this.loggedUser = user;
  }

  public getUser(): User {
    return this.loggedUser;
  }
}
