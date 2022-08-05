import {Pipe, PipeTransform} from "@angular/core";

@Pipe({
    name:'product_type'
})

export class Product_Type implements PipeTransform{

    transform(value:any){
        
        
        if(value == "ELECTRICAL_MATERIALS"){
            return "Electrical Materials";
        }
        if(value == "EQUIPMENT"){
            return "Equipment";
        }
        if(value == "LOCKSMITH"){
            return "Locksmith";
        }
        if(value == "TOOLS"){
            return "Tools";
        }
        if(value == "PLUMBING"){
            return "Plumbing";
        }
        
        else{
            return " Error: Product type missing"
        }
        
    }
}