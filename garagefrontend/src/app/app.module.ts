import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserListComponent } from './component/user-list/user-list.component';
import { UserCreateComponent } from './component/user-create/user-create.component';
import { UserService } from './service/user-service.service';

import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { UserLoginComponent } from './component/user-login/user-login/user-login.component';

@NgModule({
  declarations: [
    AppComponent,
    UserListComponent,
    UserCreateComponent,
    UserLoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
