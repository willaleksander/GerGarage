import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UserService } from '../../service/user-service.service';
import { User } from '../../model/user';

@Component({
  selector: 'app-user-create',
  templateUrl: './user-create.component.html',
  styleUrls: ['./user-create.component.css']
})
export class UserCreateComponent {
  createForm: FormGroup;
  user: User;

  constructor(
    private route: ActivatedRoute,
    private formBuilder: FormBuilder,
    private router: Router, 
    private userService: UserService) {
    this.user = new User();
  }

  ngOnInit() {
    this.createForm = this.formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required],
      name: ['', Validators.required],
      phone: ['', Validators.required]
  });
  }

  get form() { return this.createForm.controls; }

  onSubmit() {
    this.user.user_name = this.form.name.value;
    this.user.user_phone = this.form.phone.value;
    this.user.user_password = this.form.password.value;
    this.user.username = this.form.username.value;
    this.user.user_type = "Customer";
    this.userService.save(this.user).subscribe(result => this.goto());
  }

  goto() {
    this.router.navigate(['/login']);
  }
}
