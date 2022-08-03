import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from 'src/app/models/product.model';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddProductComponent implements OnInit {
  product: Product;
  category: string[];
  pname: string = "";
  constructor(private router: Router, private service: ProductService) {
    this.product = new Product(0, '', 0, 0, '');
    this.category = ['Laptops', 'Phones', 'Camera','Watch', 'TWS', 'Headphones', 'Keyboard','Mouse', 'Speakers'];
    // this.pname = ['Lenovo','Asus','Apple','Sony', 'Samsung', 'Axe Signature', 'Engage', 'Wild Stone', 'Calvin Klein', 'Fogg','Acqua Di Gio','Park Avenue Euphoria','Coco Noir Chanel','Calvin Klein','Gemma Di Paradiso','Creed X','Red Diamond','Evidence']
    this.pname = this.pname;
  }

  ngOnInit(): void {
  }
  save() {
    this.service.addProduct(this.product);
    setTimeout(()=>{
    this.router.navigate(['list']);},1000);
  }
}
