import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Address } from 'src/app/models/address.model';
import { UserAddress } from 'src/app/models/pojos/user.address.model';
import { User } from 'src/app/models/user.model';
import { AddressService } from 'src/app/services/address.service';


@Component({
  selector: 'list-address',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class ListAddressComponent implements OnInit {
  address : Address[]=[];
  user : User;
  constructor(private service: AddressService,private router : Router) {
    this.user = JSON.parse(localStorage.getItem("regularUser")!);
  }

  ngOnInit(): void {
    this.list();
    
  }
  
  list(){
    this.service.list(this.user.userId).then(data => {
      this.address = data;
    })
  }

  redirect(){
    this.router.navigate(['addAddress']);
  }

  select(idx : number){
    console.log(this.address[idx].addressId);
    localStorage.setItem("address",JSON.stringify(this.address[idx].addressId));
  }
}