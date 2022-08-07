import { Component, OnInit } from '@angular/core';
import { Validators,FormGroup, FormBuilder } from '@angular/forms';
import {UserService} from '../../services/user.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  formvalue : FormGroup = this.fb.group({
    username:[],
    password:[],
    confirm:[],
    is_admin:[]
  
 
  });
  constructor(private fb:FormBuilder,private router:Router, private userService:UserService) { }

  ngOnInit(): void {
  }

  message:string ="";

  submitted = false;

  get createFormControl() {
    return this.formvalue.controls;
  }

save(){
  this.submitted = true;
  var values = this.formvalue.value;

  if(values.is_admin == null){
    values.is_admin = false;
 }

  if(values.confirm == values.password && this.formvalue.valid ){
    console.log(values);
    this.userService.create(values) .
    subscribe( () => { 
     });
     this.router.navigate(['login']);
    this.message = "";
  }else{
    this.message = "Passwords do not match";
  }

   
}

}
