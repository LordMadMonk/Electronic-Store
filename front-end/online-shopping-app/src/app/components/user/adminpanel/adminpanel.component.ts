import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-adminpanel',
  templateUrl: './adminpanel.component.html',
  styleUrls: ['./adminpanel.component.css']
})
export class AdminpanelComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit(): void { 
  }
add(){
this.router.navigate(['addProduct'])
}
listCoupon(){
  this.router.navigate(['listCoupon'])
}
addCoupon(){
  this.router.navigate(['addCoupon'])
}
update(){
  this.router.navigate(['list'])
}
}
