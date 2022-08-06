import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {User} from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

    constructor(private http:HttpClient) {
      
     }
  
  getAll(){
    return this.http.get("http://localhost:8080/api/medmor/user");
  }

  getById(id:number){
    return this.http.get( 'http://localhost:8080/api/medmor/getsection?id='+id);
  }
  
  create(user:User){
  
    return this.http.post('http://localhost:8080/api/medmor/user',user);
  
  }

}
