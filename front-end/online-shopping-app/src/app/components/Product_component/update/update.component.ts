import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from 'src/app/models/product.model';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {

  product : Product = JSON.parse(localStorage.getItem("updateProduct")!);
  constructor(private productService : ProductService,private router : Router) { }

  ngOnInit(): void {
  }

  update(){
    console.log(this.product);
    this.productService.updateProduct(this.product);
    setTimeout(()=>{
      this.router.navigate(['list']);
    },1000);
  }
}
