import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserListComponent } from './component/user-list/user-list.component';
import { UserCreateComponent } from './component/user-create/user-create.component';
import { UserService } from './service/user-service.service';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { UserLoginComponent } from './component/user-login/user-login.component';
import { UserDashboardComponent } from './component/user-dashboard/user-dashboard.component';
import { VehicleService } from './service/vehicle-service.service';
import { SessionService } from './service/session.service';
import { AdminDashboardComponent } from './component/admin-dashboard/admin-dashboard.component';


import { AutoFocus } from './directive/auto-focus.directive';
@NgModule({
  declarations: [
    AppComponent,
    AutoFocus,
    UserListComponent,
    UserCreateComponent,
    UserLoginComponent,
    UserDashboardComponent,
    AdminDashboardComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule 
  ],
  providers: [
    UserService, 
    VehicleService, 
    SessionService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
