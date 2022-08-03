import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Address } from 'src/app/models/address.model';
import { ShoppingCart } from 'src/app/models/cart.model';
import { Coupon } from 'src/app/models/coupon.model';
import { Checkout } from 'src/app/models/pojos/checkout.model';
import { Items } from 'src/app/models/pojos/items.model';

import { User } from 'src/app/models/user.model';
import { AddressService } from 'src/app/services/address.service';
import { CartService } from 'src/app/services/cart.service';
import { CouponService } from 'src/app/services/coupon.service';

@Component({
  selector: 'app-view',
  templateUrl: './view.component.html',
  styleUrls: ['./view.component.css']
})
export class ViewComponent implements OnInit {
  items : Items[] = [];
  cart : ShoppingCart;
  addresses : Address[]=[];
  coupons : Coupon[]=[];
  address : Address;
  coupon : Coupon;
  discountedprice : number = 0;
  user : User = JSON.parse(localStorage.getItem("regularUser")!);
  constructor(private cartService : CartService, private router:Router , private addressService : AddressService , private couponService : CouponService) { 
    this.cart = new ShoppingCart(0,0,this.user);
    this.address = new Address(0,0,"","","",0,this.user);
    this.coupon = new Coupon(0,"",0);
  }

  ngOnInit(): void {
    
    this.user = JSON.parse(localStorage.getItem("regularUser")!);
    this.addressService.list(this.user.userId).then(data=>{
      this.addresses = data;
    });
    this.couponService.fetchAll().then(data =>{
      this.coupons = data;
    });
    this.cartService.fetchByUser(this.user.userId).then(data=>{
      this.cart = data;
    })
    this.cart = JSON.parse(localStorage.getItem("cart")!);
    this.cartService.viewCart(this.cart.cartid).then(data=>{
      this.items = data;
    })
  }

  selectAddress(){
      console.log(this.address);
      localStorage.setItem("deliveryAddress",JSON.stringify(this.address));
  }

  selectCoupon(){
    console.log(this.coupon);
    this.discountedprice = this.cart.total_price - ((this.cart.total_price*this.coupon.discount)/100);
    console.log(this.discountedprice);
  }

  redirect(){
    this.router.navigate(['list']);
  }
  checkout(){
    var coup = this.coupon.cid;
    var add = this.address.addressId;
    this.cartService.checkOut(new Checkout(coup,this.user.userId,add));

    this.cartService.fetchByUser(this.user.userId).then(data=>{
      this.cart = data;
      localStorage.setItem("cart",JSON.stringify(data));
      setTimeout(()=>{
        this.router.navigate(['checkout']).then(()=>window.location.reload());
      },2000);
      } );
  }
}
