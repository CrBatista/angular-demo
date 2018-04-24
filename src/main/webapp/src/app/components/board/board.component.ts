import { Component, OnInit, Output } from '@angular/core';
import { IdentityService } from '../../services/identity.service';
import { User } from '../../types/User';
import { Task } from '../../types/Task';

@Component({
  selector: 'app-board',
  templateUrl: './board.component.html',
  styleUrls: ['./board.component.css']
})
export class BoardComponent implements OnInit {

  public user: User;

  public reactivate = true;

  constructor(private identity: IdentityService) { }

  ngOnInit() {
    this.user = this.identity.getUser();
  }

  public updateSections(): void {
    this.reactivate = !this.reactivate;
  }
}
