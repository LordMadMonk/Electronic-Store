import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserProduct } from 'src/app/models/pojos/user.product.model';
import { Product } from 'src/app/models/product.model';
import { User } from 'src/app/models/user.model';
import { CartService } from 'src/app/services/cart.service';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-product-search',
  templateUrl: './product-search.component.html',
  styleUrls: ['./product-search.component.css']
})
export class ProductSearchComponent implements OnInit {
  product: Product[] = [];
  sname: string;
  scategory: string;
  namel: string[] = [];
  categoryl: string[] = [];
  f: string = '';
  highp: number = 0;
  lowp: number = 0;

  user : User = new User(0,"","","","");
  loginStatus : boolean = false;

  constructor(private service: ProductService,private cartService : CartService,private router : Router) {
    this.sname = "";
    this.scategory = "";
    this.lowp = 0;
    this.service.List().then(data => { this.categoryl = [...new Set(data.map(x => x.category))] });
    this.service.List().then(data => { this.namel = [...new Set(data.map(x => x.pname))] });

  }

  ngOnInit(): void {
    this.user = JSON.parse(localStorage.getItem("regularUser")!);
    this.loginStatus = JSON.parse(localStorage.getItem("loginStatus")!)
  }

  //searches products by name and category
  search() {
    //this works with both lower and uppercase category input
    if (this.categoryl.includes(this.f.charAt(0).toUpperCase()+this.f.slice(1))) {
      this.service.findByCategory(this.f).then(data => {
        this.product = data;
      });
    }
    else {
      this.service.findByName(this.f).then(data => {
        this.product = data;
      });
    }
  }
  // searches product by price range 
  searchbyrange() {
    this.service.findByPriceRange(this.lowp, this.highp).then(data => {
      this.product = data;
    })
  }

  //adds product ot cart
  addToCart(idx : number){
     this.cartService.addToCart(new UserProduct(this.user.userId,this.product[idx].pid));
     setTimeout(()=>{
       this.ngOnInit();
       this.searchbyrange();
     },1000);
  }
}
