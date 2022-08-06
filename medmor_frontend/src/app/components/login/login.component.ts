import { Component, OnInit } from '@angular/core';
import {User} from '../../models/user';
import {UserService} from '../../services/user.service';
import { Validators,FormGroup, FormBuilder } from '@angular/forms';

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
  constructor(private fb:FormBuilder, private userService:UserService) { }

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
          this.message = "";
         }else{
          this.message = "Wrong credentials";
          this.submitted = false;
         }
       }
     });  
  }
   
}
}
