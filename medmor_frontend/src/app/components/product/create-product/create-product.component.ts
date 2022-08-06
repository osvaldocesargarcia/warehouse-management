import { Component, OnInit } from '@angular/core';
import {SectionService} from '../../../services/section.service';
import {ProductService} from '../../../services/product.service';
import {Section} from '../../../models/section';
import { Validators,FormGroup, FormBuilder } from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router';

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
  constructor(private fb:FormBuilder, private router:Router,private activatedRoute:ActivatedRoute,  
    private sectionService:SectionService, private productService:ProductService) { 


  }

  section_list:Section[];
  section_temp:Section;
  section_message:string="";
  update_flag = false;
  submitted = false;
  update_id:number;
  update_price = "";
  update_lot = "";
  update_length = "";
  update_width = "";
  update_color="";
  header_message="Create Product";
  


  ngOnInit(): void {
    this.loadSections();
    this.loadParams();
  }


  loadSections(){
    this.sectionService.getAll().
    subscribe( (promise:any)=>{
      this.section_list = promise;
  });
  }

  loadParams(){
    this.activatedRoute.params.
    subscribe((params)=>{
      if( !(params.id == undefined)){
        this.update_flag = true;
        this.update_id= params.id;
      
        this.header_message = "Update Product #"+this.update_id;
        this.setProductValuesPlaceholder(params.color,params.length,params.width,params.lot,params.price);
      }
     
    }
  );
  }

  setProductValuesPlaceholder(color:string,length:number,width:number,lot:number,price:number){
    this.update_color = color;
    this.update_length = ""+length;
    this.update_width = ""+width;
    this.update_lot = ""+lot;
    this.update_price = ""+price;
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

      if(this.update_flag){

        
          if(values.section_id == null ){
            this.section_message = "Please select a section";
          }else{
            if(this.formvalue.valid){
            console.log("updating");
            console.log(values);
            this.productService.update(this.update_id, values, values.section_id)
              .subscribe(() => {
              });
              this.router.navigate(['product']);
          }
       }
         
      }else{
        if(values.section_id == null ){
          this.section_message = "Please select a section";
        }else{
          
          if(this.formvalue.valid){
            console.log("creating");
            console.log(values);
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

   
  
}
