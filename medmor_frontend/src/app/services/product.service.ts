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
  
  create(product:Product){
  
    return this.http.post('http://localhost:8080/api/medmor/product',product);
  
  }
}
