import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';
import { user } from '../model/user';
import { Observable } from "rxjs";
import { TokenStorageService } from '../auth/token-storage.service';
import { Router } from '@angular/router';
import { Roles } from '../model/Roles';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
  board: string;
  errorMessage: string;
  users: Observable<user[]>;
  role : Roles[];
  
  constructor(private userService: UserService,private token: TokenStorageService,private router: Router) { }

  ngOnInit() {
    this.reloadData();
    this.userService.getAdminBoard().subscribe(
      data => {
        this.board = data;
      },
      error => {
        this.errorMessage = `${error.status}: ${JSON.parse(error.error).message}`;
      }
    );
 
  };

  reloadData() {
    this.users = this.userService.getUsers();
  }

  deleteUser(id: number) {
    this.userService.deleteUser(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }
  userDetails(id: number){
    this.router.navigate(['details', id]);
  }

  logout() {
    this.token.signOut();
    window.location.reload();
  }

}


