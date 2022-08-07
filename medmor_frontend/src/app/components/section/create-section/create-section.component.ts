import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import { Validators,FormGroup, FormBuilder } from '@angular/forms';
import {SectionService} from '../../../services/section.service';


@Component({
  selector: 'app-create-section',
  templateUrl: './create-section.component.html',
  styleUrls: ['./create-section.component.scss']
})
export class CreateSectionComponent implements OnInit {

  formvalue : FormGroup = this.fb.group({
    product_type:[],
    length:[],
    width:[]
  
 
  });

  submitted = false;
  message="";

  constructor(private fb:FormBuilder,private router:Router, private sectionService:SectionService) { }

  ngOnInit(): void {
  }

  get createFormControl() {
    return this.formvalue.controls;
  }

  save(){
    this.submitted = true;
    var values = this.formvalue.value;
    
    if(values.product_type == null){
      values.product_type = "";
    }
    if(this.formvalue.valid){
      this.sectionService.create(values) .
      subscribe( () => { 
       });
       this.router.navigate(['section']);
    }
  }




}

