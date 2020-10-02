import { Component, OnInit } from '@angular/core';
import { user } from '../model/user';
import { Observable } from "rxjs";
import { TokenStorageService } from '../auth/token-storage.service';
import { UserService } from '../services/user.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  info: any;
  
  constructor(private token: TokenStorageService) { }

  ngOnInit() {
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
