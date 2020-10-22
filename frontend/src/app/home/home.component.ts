import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { TokenStorageService } from '../auth/token-storage.service';
import { Roles } from '../model/Roles';
import { user } from '../model/user';
import { UserService } from '../services/user.service';
import { Router, ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  id: number;
  user: user;
  roles : Roles[]
  info : any;

  
  constructor(private route: ActivatedRoute,private router: Router,private token: TokenStorageService,private userService: UserService) { }

  ngOnInit() {

    this.user = new user();

    this.id = this.route.snapshot.params['id'];

    this.userService.getUserDetails(this.id)
      .subscribe(data => {
        console.log(data)
        this.user = data;
      }, error => console.log(error));

      this.info = {
        token: this.token.getToken(),
        username: this.token.getUsername(),
        authorities: this.token.getAuthorities()
      };

     
  }

  logout() {
    this.token.signOut();
    window.location.reload();
  }
}
