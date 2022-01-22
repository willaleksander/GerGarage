import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../model/user';
import { Login } from '../model/login';
import { Observable } from 'rxjs';
import { ApiResponse } from '../model/api-response';

@Injectable()
export class UserService {

  private url: string;

  constructor(private http: HttpClient) {
    this.url = 'http://localhost:8080';
  }

  public findAll(): Observable<any> {
    return this.http.get<any>(this.url+"/list-users");
  }

  public save(user: User) {
    return this.http.post<User>(this.url+"/create", user);
  }

  public login(login: Login) {
    return this.http.post<ApiResponse>(this.url+"/login", login);
  }
}