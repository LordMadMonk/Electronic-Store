import { DatePipe } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { firstValueFrom } from 'rxjs';
import { Order } from '../models/order.model';
import { Items } from '../models/pojos/items.model';
import { Product } from '../models/product.model';

@Injectable({
  providedIn: 'root'
})
export class OrderService {
  private static url : string = "http://localhost:8880/Order";

  constructor(private http:HttpClient) { }

  async getOrder(oid : String){
    const ord$ = this.http.get<Order>(OrderService.url+"/getById/"+oid);
    return await firstValueFrom(ord$);
  }

  async getByUserId(uid: number){
    const order$= this.http.get<Order[]>(OrderService.url+"/get/"+uid);
    return await firstValueFrom(order$);
  }

  async viewProducts(oid: String){
    const item$=this.http.get<Items[]>(OrderService.url+"/details/"+oid);
    return await firstValueFrom(item$);
  }
}
