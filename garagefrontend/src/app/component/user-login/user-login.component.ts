import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Login } from 'src/app/model/login';
import { UserService } from 'src/app/service/user-service.service';

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent implements OnInit {
  loginForm: FormGroup;
  login: Login;

  constructor(
    private router: Router, 
    private formBuilder: FormBuilder,
    private route: ActivatedRoute, 
    private userService: UserService) {
      this.login = new Login();
  }

  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
  });
  }

  get form() { return this.loginForm.controls; }

  onSubmit() {

    this.login.username = this.form.username.value;
    this.login.password = this.form.password.value;
    
    this.userService.login(this.login).subscribe(
        result => {
          sessionStorage.setItem("user_type", result.result.user_type)
          sessionStorage.setItem("logged", "true")
          sessionStorage.setItem("user_id", result.result.user_id)
          this.router.navigate([result.result.user_type=='Admin'?'/admin-dashboard':'/user-dashboard'])
        },
        error => {console.log(error)}          
      );
  }

  
}
