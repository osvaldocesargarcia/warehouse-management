import { Component, OnInit } from '@angular/core';
import {SectionService} from '../../../services/section.service';
import {ProductService} from '../../../services/product.service';
import {Section} from '../../../models/section';
import { Validators,FormGroup, FormBuilder } from '@angular/forms';
import {Router} from '@angular/router';

@Component({
  selector: 'app-create-product',
  templateUrl: './create-product.component.html',
  styleUrls: ['./create-product.component.scss']
})
export class CreateProductComponent implements OnInit {

  formvalue : FormGroup = this.fb.group({
    section_id:[],
    color:[],
    is_fragile:[],
    length:[],
    lot:[],
    price:[],
    width:[],
    product_type:[],
    container_type:[]
  
 
  });
  constructor(private fb:FormBuilder, private router:Router,  private sectionService:SectionService, private productService:ProductService) { }

  section_list:Section[];
  section_temp:Section;
  section_message:string="";
  submitted = false;
  


  ngOnInit(): void {
    this.sectionService.getAll().
    subscribe( (promise:any)=>{
      this.section_list = promise;
      
  });
  }

  get createFormControl() {
    return this.formvalue.controls;
  }
 

  save(){
      this.submitted = true;     
      var values = this.formvalue.value;

      if(values.is_fragile == null){
         values.is_fragile = false;
      }

      if(values.section_id == null ){
        this.section_message = "Please select a section";
      }else{
        
        if(this.formvalue.valid){
          console.log("form valid");
          this.section_message = "";
          this.productService.create(values, values.section_id)
          .subscribe( () => {
           
          }   
          );
        }
        this.router.navigate(['product']);
      }


    }

   
  
}
