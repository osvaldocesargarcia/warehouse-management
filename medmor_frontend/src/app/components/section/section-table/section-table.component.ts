import { Component, OnInit } from '@angular/core';
import {SectionService} from '../../../services/section.service';
import {ProductService} from '../../../services/product.service';
import {UserService} from '../../../services/user.service';
import {Section} from '../../../models/section';
import {Product} from '../../../models/product';

@Component({
  selector: 'app-section-table',
  templateUrl: './section-table.component.html',
  styleUrls: ['./section-table.component.scss']
})
export class SectionTableComponent implements OnInit {

section_list:Section[];
temp_count_products:number;
containsProducts = true;
section_message="";
is_admin:boolean;
constructor(private sectionService:SectionService,private productService:ProductService, private userService:UserService) { }

ngOnInit(): void {
  this.sectionService.getAll().
  subscribe( (promise:any)=>{
    this.section_list = promise;
   
});

var logged_user = ""+this.userService.getUserLogged();
this.userService.isAdmin(logged_user).
    subscribe((promise:any)=>{
      this.is_admin = promise;
       
    });
  
}


delete(section:Section){

  this.hasProducts(section);
  
 
  
 
}

hasProducts(section:Section){

  this.productService.getBySection(section.section_id).

  subscribe((promise: any) => {
    this.temp_count_products = promise.length;
    

    if(this.temp_count_products == 0){
      
     

      this.sectionService.delete(section.section_id).
      subscribe(()=>{}
    
      );
      this.section_message="";
      window.location.reload();
    }else{
      this.section_message="Can't delete a section with products";
    }
    
  });
 

}

}
