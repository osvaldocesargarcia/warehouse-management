import { Component, OnInit } from '@angular/core';
import {SectionService} from '../../../services/section.service';
import {ProductService} from '../../../services/product.service';
import {Section} from '../../../models/section';
import { FormGroup, FormBuilder } from '@angular/forms';

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
  constructor(private fb:FormBuilder,   private sectionService:SectionService, private productService:ProductService) { }

  section_list:Section[];
  section_temp:Section;
  section_message:string="";


  ngOnInit(): void {
    this.sectionService.getAll().
    subscribe( (promise:any)=>{
      this.section_list = promise;
      
  })
  }

  save(){
    
      var values = this.formvalue.value;
      

      if(values.is_fragile == null){
        
        values.is_fragile = false;
       
      }

      if(values.section_id == null ){
        this.section_message = "Please select a section";
       

      }else{
        
        this.section_message = "";
     
      
        

        this.productService.create(values, values.section_id)
        .subscribe( () => {
         
        }   
        );
      }
    
      //console.log("values",values);
      /**/


    }
}
