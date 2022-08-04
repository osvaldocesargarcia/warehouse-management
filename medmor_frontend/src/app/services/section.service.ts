import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Section} from '../models/section';

@Injectable({
  providedIn: 'root'
})
export class SectionService {

   
  
   private baseURL = "http://localhost:8080/api/medmor/section"
   
     constructor(private http:HttpClient) {
       
      }
   
   getAll(){
     return this.http.get(this.baseURL);
   }
   
   create(section:Section){
   
     return this.http.post('http://localhost:8080/api/medmor/section',section);
   
   }
}
