import { isNull } from '@angular/compiler/src/output/output_ast';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AppComponent } from 'src/app/app.component';
import { Login } from 'src/app/models/pojos/login.model';
import { User } from 'src/app/models/user.model';
import { AddressService } from 'src/app/services/address.service';
import { CartService } from 'src/app/services/cart.service';
import { UserService } from 'src/app/services/registration.service';

@Component({
  selector: 'app-loginsuccess',
  templateUrl: './loginsuccess.component.html',
  styleUrls: ['./loginsuccess.component.css']
})
export class LoginsuccessComponent implements OnInit {
  viewAdd : boolean = false;
  viewOrd : boolean = false;
  addressStatus : boolean = false;
  user : User ;
  constructor(private cartService : CartService,private addressService : AddressService,private  userService : UserService,private router : Router) {
    this.user = new User(0,"","","","");
    
  }

  ngOnInit(): void {
    this.user = JSON.parse(localStorage.getItem("regularUser")!);


    this.cartService.fetchByUser(this.user.userId).then(data=>{
      localStorage.setItem("cart",JSON.stringify(data));
    })
    this.addressService.list(this.user.userId).then(data=>{
      console.log("addressStatus ",data.length,this.addressStatus);
      if(data.length === 0){
        this.addressStatus = true;
        console.log("addressStatus ",data.length,this.addressStatus);
      }
    })
  }

  refresh(){
    this.userService.loginUserFromRemote(new Login(this.user.email,this.user.password)).then((data)=>{
      this.addressStatus=false;
      localStorage.setItem("regularUser",JSON.stringify(data));
      setTimeout(()=>{this.ngOnInit();},1000);
    })
  }

  viewOrders(){
    this.viewOrd = !this.viewOrd;
    this.viewAdd =false;
  }

  viewAddresses(){
    this.viewAdd = !this.viewAdd;
    this.viewOrd = false;
  }
}
