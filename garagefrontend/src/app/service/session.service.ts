import { Injectable } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class SessionService {

  constructor(private router: Router) { }

  public getLogged() {
    return JSON.parse(sessionStorage.getItem("logged")!)
  }

  public getUserType() {
    return sessionStorage.getItem("user_type")
  }

  public getUserId() {
    return sessionStorage.getItem("user_id")
  }

  public checkLogged() {
    if (!this.getLogged() && !this.getUserId())
      this.router.navigate(['/']);
  }

  public checkUserType(type?: String) {
    if (type!=null && type != sessionStorage.getItem("user_type")){
      this.router.navigate(['/']);
    }

    if (this.getUserType() == "Customer")
      this.router.navigate(['/user-dashboard']);
    else if (this.getUserType() == "Admin")
      this.router.navigate(['/admin-darshboard']);
  }

  public checkSession(type: boolean){
    if (!this.getLogged()){
      this.router.navigate(['/']);
      return
    }
    if (type){
      if (this.getUserType() == "Customer")
        this.router.navigate(['/user-dashboard']);
      else if (this.getUserType() == "Admin")
        this.router.navigate(['/admin-dashboard']);
      else
        this.router.navigate(['/']);
      return
    }

  }
}
