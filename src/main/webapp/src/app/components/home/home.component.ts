import { Component, OnInit } from '@angular/core';
import { User } from '../../types/User';
import { UserService } from '../../services/user.service';
import { IdentityService } from '../../services/identity.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  public users: User[];

  constructor(private userService: UserService, private identity: IdentityService, private router: Router) { }

  ngOnInit() {
    this.userService.findUsers().subscribe((data) => {
      this.users = data;
    });
  }

  public doLogin(user: User): void {
    this.identity.doLogin(user);
    this.router.navigate(['/user/' + user.id]);
  }

}
