import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Address } from 'src/app/models/address.model';
import { UserAddress } from 'src/app/models/pojos/user.address.model';
import { User } from 'src/app/models/user.model';
import { AddressService } from 'src/app/services/address.service';

@Component({
  selector: 'add-address',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddAddressComponent implements OnInit {
  address : UserAddress;
  state : string[];
  num : number = 0;
  user : User = JSON.parse(localStorage.getItem("regularUser")!);
  constructor(private service : AddressService,private router : Router) { 
    this.address = new UserAddress(0,this.user.userId,0,'','','',0);
    this.state =  ["Andhra Pradesh","Goa","West Bengal","Bihar","Kerala",'Haryana','Manipur','Sikkim','Arunachal Pradesh','Himachal Pradesh','Jharkhand','Karnataka','Madhya Pradesh','Maharashtra','Manipur','Meghalaya','Mizoram','Nagaland','Odisha','Punjab','Rajasthan','Sikkim','Tamil Nadu','Telengana','Tripura','Uttarakhand','Assam','Gujrat'];
   
  }

  ngOnInit(): void {
    this.service.ListAllAddress().then((data)=>{
      this.num = data.map(x=>x.addressId)[data.map(x=>x.addressId).length-1]+1;
      console.log(this.num);
      this.address.aid = this.num;
    })
  }

  add(){
    this.service.add(this.address);
    setTimeout(()=>{
    this.router.navigate(['loginsuccess'])},1000);
  }

}
