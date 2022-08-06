import { Injectable } from '@angular/core';
import {CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot} from '@angular/router';
import {UserService} from '../services/user.service';
import {Router} from '@angular/router';
@Injectable({
  providedIn: 'root'
})
export class NotLoggedRouteGuardService {

  constructor(private userService:UserService, private router:Router) { }

  canActivate(route:ActivatedRouteSnapshot, state:RouterStateSnapshot){
    if(!this.userService.isUserLoggedIn()){
      return true;
    }else{
      this.router.navigate(['home']);
      return false;
    }

  }

 



}
