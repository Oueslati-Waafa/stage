import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private studentUrl = 'http://localhost:9920/api/student';
  private teacherUrl = 'http://localhost:9920/api/teacher';
  private adminUrl = 'http://localhost:9920/api/admin';
  private usersUrl = 'http://localhost:9920/api/admin/users';
  private userDeleteUrl = 'http://localhost:9920/api/admin/delete';
  private userDetailUrl = 'http://localhost:9920/api/admin/user';
 
  

  constructor(private http: HttpClient) { }

  getUserBoard(): Observable<string> {
    return this.http.get(this.studentUrl, { responseType: 'text' });
  }

  getPMBoard(): Observable<string> {
    return this.http.get(this.teacherUrl, { responseType: 'text' });
  }

  getAdminBoard(): Observable<string> {
    return this.http.get(this.adminUrl, { responseType: 'text' });
  }

  getUsers(): Observable<any> {
    return this.http.get(`${this.usersUrl}`);
  }
  getUserDetails (id: number): Observable<any> {
    return this.http.get(`${this.usersUrl}/${id}`);
  }
  deleteUser(id: number): Observable<any> {
    return this.http.delete(`${this.userDeleteUrl}/${id}`, { responseType: 'text' });
  }

}
