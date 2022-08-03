import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Coupon } from 'src/app/models/coupon.model';
import { CouponService } from 'src/app/services/coupon.service';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddCouponComponent implements OnInit {

  coupon : Coupon;
  constructor(private couponService : CouponService,private router : Router) {
    this.coupon = new Coupon(0,"",0);
  }

  ngOnInit(): void {
  }

  addCoupon(){
    this.couponService.addCoupon(this.coupon);
    setTimeout(()=>{
    this.router.navigate(['listCoupon'])},1000);
  }
}
