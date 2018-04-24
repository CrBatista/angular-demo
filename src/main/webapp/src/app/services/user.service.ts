import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { User } from '../types/User';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';

@Injectable()
export class UserService {

  constructor(private httpClient: HttpClient) { }

  public findUsers(): Observable<User[]> {
    return this.httpClient.get<User[] | null>(environment.baseUrl + 'user/all');
  }
}
