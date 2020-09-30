import { Component, OnInit } from '@angular/core';
import { UserService } from './../services/user.service';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {
  board: string;
  errorMessage: string;

  constructor(private studentService: UserService) { }

  ngOnInit() {
    this.studentService.getUserBoard().subscribe(
      data => {
        this.board = data;
      },
      error => {
        this.errorMessage = `${error.status}: ${JSON.parse(error.error).message}`;
      }
    );
  }
}