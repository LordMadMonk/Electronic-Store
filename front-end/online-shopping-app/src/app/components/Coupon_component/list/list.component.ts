import { Component, OnInit } from '@angular/core';
import { Coupon } from 'src/app/models/coupon.model';
import { CouponService } from 'src/app/services/coupon.service';

@Component({
  selector: 'list-coupon',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListCouponComponent implements OnInit {

  coupons : Coupon[] = []
  constructor(private  couponService : CouponService) { }

  ngOnInit(): void {
    this.fetchAll();
  }

  fetchAll(){
    this.couponService.fetchAll().then(data=>{
      this.coupons = data;
    });
  }

  selectCoup(idx : number){
    console.log(this.coupons[idx].cid);
    localStorage.setItem("coupon",JSON.stringify(this.coupons[idx].cid));
  }
}
