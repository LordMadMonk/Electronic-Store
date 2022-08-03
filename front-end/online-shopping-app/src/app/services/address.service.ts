import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { firstValueFrom } from 'rxjs';
import { Address } from '../models/address.model';
import { UserAddress } from '../models/pojos/user.address.model';


@Injectable({
  providedIn: 'root'
})
export class AddressService {
  private static url : string = "http://localhost:8880/Address";
  
  constructor(private http : HttpClient) { }

  add(address : UserAddress){
    this.http.post(AddressService.url+"/add",address).subscribe(data=>{data = address; });
  }

  async ListAllAddress(){
    const address$= this.http.get<Address[] > (AddressService.url+"/list");
    return await firstValueFrom(address$);
  }
  
  async list(uid : number) {
    const address$ = this.http.get<Address[]>(AddressService.url + "/getByUser/" + uid);
     return await firstValueFrom(address$);
   }

}
