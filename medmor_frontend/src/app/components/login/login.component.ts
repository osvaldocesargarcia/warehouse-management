import { Component, OnInit } from '@angular/core';
import {User} from '../../models/user';
import {UserService} from '../../services/user.service';
import {SharedService} from '../../services/shared.service';
import { Validators,FormGroup, FormBuilder } from '@angular/forms';
import {Router} from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  formvalue : FormGroup = this.fb.group({
    username:[],
    password:[],
    
  
 
  });
  constructor(private fb:FormBuilder, private router:Router,private userService:UserService, private _sharedService: SharedService) { }

  ngOnInit(): void {
  }

  message:string ="";
  user:User;

  submitted = false;

  get createFormControl() {
    return this.formvalue.controls;
  }

save(){
  this.submitted = true;
  var values = this.formvalue.value;
  


  if(this.formvalue.valid ){

    this.userService.login(values) .
    subscribe( (promise:any) => {     
      this.user = promise;

      if(this.user.username == undefined){
        this.message="User not found";

       }else{

        if(this.user.username == values.username && this.user.password == values.password){
          console.log("Login successful");
          this._sharedService.emitChange(this.user.username);
          sessionStorage.setItem('authenticatedUser',""+this.user.username);
          this.router.navigate(['home']);
          
         }else{
          this.message = "Wrong credentials";
          this.submitted = false;
         }
       }
     });  
  }
   
}
}
