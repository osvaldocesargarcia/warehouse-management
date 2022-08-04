import { Component, OnInit } from '@angular/core';
import {ProductService} from '../../../services/product.service';
import {Product} from '../../../models/product';

@Component({
  selector: 'app-product-table',
  templateUrl: './product-table.component.html',
  styleUrls: ['./product-table.component.scss']
})
export class ProductTableComponent implements OnInit {

  product_list:Product[];
  constructor(private productService:ProductService) { }
  
  ngOnInit(): void {
    this.productService.getAll().
    subscribe( (promise:any)=>{
      this.product_list = promise;
      
  })
  }

  
  
}
