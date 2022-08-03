import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Route, Router } from '@angular/router';
import { AppComponent } from 'src/app/app.component';
import { Login } from 'src/app/models/pojos/login.model';
import { User } from 'src/app/models/user.model';
import { UserService } from 'src/app/services/registration.service';
import { RegisterComponent } from '../register/register.component';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user: User;
  login : Login;
  isLoggedIn:Boolean=false;
  isAdmin : boolean = false;
  message : string = "";
  constructor(private service: UserService, private route: Router) {
    this.user = new User(0, "", "", "", "");
    this.login = new Login("","");
  }

  ngOnInit(): void {
  }

  loginUser() {

    
    if(this.login.email === "admin" && this.login.pass === "admin"){
      this.isLoggedIn=true;
      this.isAdmin = true;
      localStorage.setItem("loginStatus",JSON.stringify(this.isLoggedIn));
      localStorage.setItem("adminStatus",JSON.stringify(this.isAdmin));
      this.route.navigate(['adminpanel']).then(()=>{window.location.reload()});
    }
    else{
      this.service.loginUserFromRemote(this.login).then((data) => {
        this.user = data;
        this.isLoggedIn=true;
        localStorage.setItem("loginStatus",JSON.stringify(this.isLoggedIn));
        localStorage.setItem("regularUser", JSON.stringify(this.user));
        setTimeout(()=>{
          this.route.navigate(['loginsuccess']).then(()=>{
            window.location.reload()}
          )},1000);
      },
      (error : HttpErrorResponse)=>{
        this.message = error.error.message;
      });
    }
  }

}
