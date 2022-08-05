import {Pipe, PipeTransform} from "@angular/core";

@Pipe({
    name:'container_type'
})

export class Container_Type implements PipeTransform{

    transform(value:any){
       
        
        if(value == "CARTON"){
            return "Carton";
        }
        if(value == "PLASTIC"){
            return "Plastic";
        }
        if(value == "GLASS"){
            return "Glass";
        }
        if(value == "NYLON"){
            return "Nylon";
        }
      
        
        else{
            return " Error: Container type missing"
        }
        
    }
}