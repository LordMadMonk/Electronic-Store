import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { firstValueFrom } from 'rxjs';
import { Coupon } from '../models/coupon.model';

@Injectable({
  providedIn: 'root'
})
export class CouponService {
  private static url : string = "http://localhost:8880/Coupon";
  constructor(private http : HttpClient) { }

  //adding a new coupon
  addCoupon(coupon : Coupon){
   this.http.post<Coupon>(CouponService.url+"/add",coupon).subscribe(data=>{
      data=coupon;
    });
  }

  //fetching a particular coupon by coupon id
  async fetch(cid : number){
    const coup$ = this.http.get<Coupon>(CouponService.url+"/fetch?cid="+cid);
    return await firstValueFrom(coup$);
  }

  //fetch a list of coupon
  async fetchAll(){
    const coups$ = this.http.get<Coupon[]>(CouponService.url+"/fetchAll");
    return await firstValueFrom(coups$);
  }
}
