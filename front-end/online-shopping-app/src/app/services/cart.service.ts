import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { firstValueFrom } from 'rxjs';
import { ShoppingCart } from '../models/cart.model';
import { Order } from '../models/order.model';
import { Checkout } from '../models/pojos/checkout.model';
import { Items } from '../models/pojos/items.model';
import { UserProduct } from '../models/pojos/user.product.model';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  private static url : string = "http://localhost:8880/Cart";
  constructor(private http : HttpClient) { }

  //crateing a cart when the user registers
  createCart(uid : number){
    this.http.post(CartService.url+"/create/"+uid,{}).subscribe(data=>{data=uid});
  }

  //adding items to cart
  addToCart(up : UserProduct){
    this.http.post(CartService.url+"/addToCart",up).subscribe(
      {next : (data)=>{data = up;},
      error : (error : HttpErrorResponse)=>{
        if(error.error.text!=undefined)
          alert(error.error.text);
      }
    });
  }

  //placing an order
  async checkOut(co : Checkout){
    this.http.post(CartService.url+"/Checkout",co).subscribe({
      next :(data)=>{data=co;},
      error:(error : HttpErrorResponse)=>{localStorage.setItem("order",JSON.stringify(error.error.text))}
    });
  }
  //fetching a cart when a user logs in
  async fetchByUser(uid : number){
    const cart$ = this.http.get<ShoppingCart>(CartService.url+"/fetchByUserID/"+uid);
    return await firstValueFrom(cart$);
  }
  //viewing a cart
  async viewCart(cartid : number){
    const items$ = this.http.get<Items[]>(CartService.url+"/view/"+cartid);
    return await firstValueFrom(items$);
  }
}
