import { Component, OnInit } from '@angular/core';
import {SharedService} from '../../services/shared.service';
import {UserService} from '../../services/user.service';
import {User} from '../../models/user';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {

  username = "";
 

  constructor(private _sharedService: SharedService, private userService:UserService) { 
    _sharedService.changeEmitted$.subscribe(param => {
      
      this.username = param;
      
      
  });

  }

  logout():void{
    
    this.userService.logout();
    this.username = "";
  }
  ngOnInit(): void {
    this.username = ""+this.userService.getUserLogged();
  }

}



