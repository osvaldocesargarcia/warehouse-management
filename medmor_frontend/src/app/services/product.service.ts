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
  
    return this.http.post('http://localhost:8080/api/medmor/product?section_id='+section_id,product);
  
  }

  getBySection(id:number){
    return this.http.get( 'http://localhost:8080/api/medmor/products_by_section?section_id='+id);
  }

  getByPriceRange(min:number,max:number){
    return this.http.get( 'http://localhost:8080/api/medmor/product_price_interval?min='+min+'&max='+max);
    
  }

  getByContainer(container_type:string){
    return this.http.get( 'http://localhost:8080/api/medmor/product_container?container_type='+container_type);
   
    
  }

  getByFragility(is_fragile:number){
    return this.http.get( 'http://localhost:8080/api/medmor/product_fragile?is_fragile='+is_fragile);
    
  }

  getByLot(lot:number){
    return this.http.get( 'http://localhost:8080/api/medmor/product_lot?lot='+lot);
    
  }

  getByColor(color:string){
    return this.http.get( 'http://localhost:8080/api/medmor/product_color?color='+color);
    
  }
  

}
