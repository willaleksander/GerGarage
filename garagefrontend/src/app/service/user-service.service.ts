import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../model/user';
import { Observable } from 'rxjs';

@Injectable()
export class UserService {

  private usersUrl: string;

  constructor(private http: HttpClient) {
    this.usersUrl = 'http://localhost:8080';
  }

  public findAll(): Observable<any> {
    return this.http.get<any>(this.usersUrl+"/list-users");
  }

  public save(user: User) {
    return this.http.post<User>(this.usersUrl+"/create", user);
  }
}