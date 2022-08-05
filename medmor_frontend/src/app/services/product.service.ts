import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Product} from '../models/product';


@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private baseURL = "http://localhost:8080/api/medmor/product"

    constructor(private http:HttpClient) {
      
     }
  
  getAll(){
    return this.http.get(this.baseURL);
  }
  
  create(product:Product, section_id:number){
    console.log("id = "+section_id);
    console.log("boolean = "+product.is_fragile);


       
 
  console.log(product);
    //console.log(product.section_assigned.section_id);
    return this.http.post('http://localhost:8080/api/medmor/product?section_id='+section_id,product);
  
  }
}
