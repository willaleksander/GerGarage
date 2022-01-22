
import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';


import { SessionService } from './service/session.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = "Ger's Garage";
  
  
  constructor (private sessionService: SessionService,
    private router: Router,){
      this.loggOut();
  }

  getLogged() {
    return this.sessionService.getLogged();
  }

  getUserType() {
    return this.sessionService.getUserType();
  }

  getRouteName() {
    return this.router.url;
  }

  loggOut() {
    sessionStorage.setItem("user_type","Customer")
    sessionStorage.removeItem("user_id")
    sessionStorage.setItem("logged", "false")
  }
}
