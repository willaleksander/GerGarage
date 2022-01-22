import { Component, OnInit } from '@angular/core';
import { SessionService } from 'src/app/service/session.service';

@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css']
})
export class AdminDashboardComponent implements OnInit {
  actualForm: String;

  constructor(private sessionService: SessionService) { }

  ngOnInit(): void {
    this.sessionService.checkSession(true);

    this.actualForm = "booking";
  }
  
  setActualForm(a: String){
    this.actualForm = a;
  }

  getActualForm(){
    return this.actualForm;
  }
}
