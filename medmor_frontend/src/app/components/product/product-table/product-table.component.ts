import { Component, OnInit } from '@angular/core';
import {ProductService} from '../../../services/product.service';
import {Product} from '../../../models/product';
import { Validators,FormGroup, FormBuilder } from '@angular/forms';
import {SectionService} from '../../../services/section.service';
import {Section} from '../../../models/section';

@Component({
  selector: 'app-product-table',
  templateUrl: './product-table.component.html',
  styleUrls: ['./product-table.component.scss']
})
export class ProductTableComponent implements OnInit {

  formvalue : FormGroup = this.fb.group({
    section_id:[],
    lot:[],
    color:[],
    is_fragile:[],
   price:[],
   container_type:[],
   min:[],
   max:[]

      });
  product_list:Product[];
  section_list:Section[];
  section_message:string="";
  submitted = false;
  options = ['Section','Lot','Fragility','Color','Price Range','Container Material'];
  selected_value:string='Section';

  constructor(private fb:FormBuilder, private sectionService:SectionService,private productService:ProductService) { }
  
  
  get createFormControl() {
    return this.formvalue.controls;
  }


  ngOnInit(): void {
    this.productService.getAll().
    subscribe( (promise:any)=>{
      this.product_list = promise;
      
  });

  this.sectionService.getAll().
  subscribe( (promise:any)=>{
    this.section_list = promise;
    
});

  }

  save() {
    this.submitted = true;
    var values = this.formvalue.value;
   
   
      if (this.selected_value == 'Section') {
        if (values.section_id == null) {
          this.section_message = "Please select a section";
        } else {
     
      
          this.filterSection(values.section_id);
        }
      }
      else if ( this.selected_value == 'Lot') {
      
        this.filterLot(values.lot);
      }
      else if (this.selected_value == 'Fragility'){
        
        if(values.is_fragile=='Yes'){     
          this.filterFragility(1);
        }else{
          this.filterFragility(0);
        }
        
      }

      else if (this.selected_value == 'Color'){
        this.filterColor(values.color);
        
      }
      else if (this.selected_value == 'Price Range'){
        this.filterRange(values.min,values.max);
        
      }
      else if (this.selected_value == 'Container Material'){
        console.log(values);
      this.filterContainer(values.container_type);
        
      }
    
  }



  filterSection(section_id: number) {
    this.productService.getBySection(section_id).
      subscribe((promise: any) => {
        this.product_list = promise;
      });
  }

  filterLot(lot: number) {
    this.productService.getByLot(lot).
      subscribe((promise: any) => {
        this.product_list = promise;
      });
  }

  filterFragility(lot: number) {
    this.productService.getByFragility(lot).
      subscribe((promise: any) => {
        this.product_list = promise;
      });
  }

  filterColor(color: string) {
    this.productService.getByColor(color).
      subscribe((promise: any) => {
        this.product_list = promise;
      });
  }

  filterRange(min:number,max:number) {
    this.productService.getByPriceRange(min,max).
      subscribe((promise: any) => {
        this.product_list = promise;
      });
  }

  filterContainer(container_type:string){
    this.productService.getByContainer(container_type).
    subscribe((promise: any) => {
      this.product_list = promise;
    });
  }

  
}
