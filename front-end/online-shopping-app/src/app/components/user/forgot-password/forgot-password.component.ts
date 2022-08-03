import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/registration.service';

@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.css']
})
export class ForgotPasswordComponent implements OnInit {
  email: any;
  constructor(private service: UserService ,private router : Router) { 
  }

  ngOnInit(): void {

  }
  forgetpass(){
    this.service.forgotpassword(this.email);
    this.router.navigate(['afterforgot']);
  }

}