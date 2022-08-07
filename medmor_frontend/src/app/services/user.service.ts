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
   
  login(user:User){
    
      return this.http.post('http://localhost:8080/api/medmor/login',user);
    
    }

  isUserLoggedIn(){
    let user = sessionStorage.getItem('authenticatedUser');
    
    return !(user===null);
  }

  isAdmin(username:string){
    return this.http.get("http://localhost:8080/api/medmor/is_admin?username="+username);
                                
 }

  getUserLogged(){
    if(this.isUserLoggedIn()){
      let user = sessionStorage.getItem('authenticatedUser');
      return user;
    }
    return "";
  }

  logout(){
    sessionStorage.removeItem('authenticatedUser');
  }

 

}
