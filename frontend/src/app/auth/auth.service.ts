import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

import { JwtResponse } from './jwt-response';
import { AuthLoginInfo } from './login-info';
import { SignUpInfo } from './signup-info';
import { SignUpTeacherInfo } from './signup-teacher';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private loginUrl = 'http://localhost:9920/api/auth/signin';
  private signupUrl = 'http://localhost:9920/api/admin/addUser';
  private signuptUrl = 'http://localhost:9920/api/admin/addUser';

  constructor(private http: HttpClient) {
  }

  attemptAuth(credentials: AuthLoginInfo): Observable<JwtResponse> {
    return this.http.post<JwtResponse>(this.loginUrl, credentials, httpOptions);
  }

  signUp(info: SignUpInfo): Observable<string> {
    return this.http.post<string>(this.signupUrl, info, httpOptions);
  }
  signUpTeacher(info: SignUpTeacherInfo): Observable<string> {
    return this.http.post<string>(this.signuptUrl, info, httpOptions);
  }
}
