import { Component, OnInit } from '@angular/core';
import { Route, Router } from '@angular/router';
import { User } from 'src/app/models/user.model';
import { CartService } from 'src/app/services/cart.service';
import { UserService } from 'src/app/services/registration.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  user: User;
  uid : number = 0;
  constructor(private service : UserService,private cartService : CartService, private _router : Router) {
    this.user = new User(0, "", "", "", "");
  }

  ngOnInit(): void {
    this.service.findall().then((data)=>{
      this.uid = data.map(x=>x.userId)[data.map(x=>x.userId).length-1]+1;
      this.user.userId=this.uid;
      console.log(this.uid);
    })
  }
  
  registerUser(){
    this.service.registerUserFromRemote(this.user);
    setTimeout(()=>{
      this.cartService.createCart(this.user.userId);
      this._router.navigate(['login']);
    },1000);
  }

}
