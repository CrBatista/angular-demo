import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { BoardComponent } from './components/board/board.component';
import { TaskComponent } from './components/task/task.component';
import { HeaderComponent } from './components/header/header.component';
import { UserService } from './services/user.service';
import { TaskService } from './services/task.service';
import { HttpClientModule } from '@angular/common/http';
import { UserBoxComponent } from './components/user-box/user-box.component';
import { Routes, RouterModule } from '@angular/router';
import { IdentityService } from './services/identity.service';
import { SectionComponent } from './components/section/section.component';
import { FormsModule } from '@angular/forms';
import { TaskPipe } from './pipes/task.pipe';

const appRoutes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'user/:id', component: BoardComponent }
];


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    BoardComponent,
    TaskComponent,
    HeaderComponent,
    UserBoxComponent,
    TaskPipe,
    SectionComponent
  ],
  imports: [
    RouterModule.forRoot(appRoutes),
    BrowserModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    UserService,
    TaskService,
    IdentityService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
