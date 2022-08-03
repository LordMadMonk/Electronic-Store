import { DatePipe, DATE_PIPE_DEFAULT_TIMEZONE } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Address } from 'src/app/models/address.model';
import { ShoppingCart } from 'src/app/models/cart.model';
import { Order } from 'src/app/models/order.model';
import { Items } from 'src/app/models/pojos/items.model';
import { User } from 'src/app/models/user.model';
import { CartService } from 'src/app/services/cart.service';
import { OrderService } from 'src/app/services/order.service';

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent implements OnInit {
  message : String = "";
  date : DatePipe = new DatePipe('en-US');
  order : Order;
  user : User = JSON.parse(localStorage.getItem("regularUser")!);
  add : Address = JSON.parse(localStorage.getItem("deliveryAddress")!);
  n : Date;
  s: String='';
  constructor(private orderService : OrderService, private router:Router) {  
   this.order = new Order("",0,"",this.date,this.user,this.add);
   this.n= new Date();
  }

  ngOnInit(): void {
    this.message = JSON.parse(localStorage.getItem("order")!);
    this.s= this.n.toLocaleString("en-AU");
    this.orderService.getOrder(this.message).then(data=>{
      this.order = data;
    });
  }
  shop(){
    this.router.navigate(['list'])
  }
  dash(){
    this.router.navigate(['loginsuccess'])
  }
}
