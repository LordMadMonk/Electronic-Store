import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginComponent } from './components/user/login/login.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'Fragnance World';
  status : boolean = false;
  admin : boolean = false;
  constructor(public router:Router){}

  ngOnInit(): void {
    
    this.status = JSON.parse(localStorage.getItem("loginStatus")!);
    this.admin = JSON.parse(localStorage.getItem("adminStatus")!);
  }

  goToCart(){
    setTimeout(()=>{
    this.router.navigate(['viewCart']);}
    ,1000);
  }

  logout(){
    localStorage.clear();
    this.status = false;
    this.router.navigate(['']);
  }
}
