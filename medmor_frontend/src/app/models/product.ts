
import {Section} from '../models/section';
export class Product {

    product_id:number;
    color:string;
    is_fragile:boolean;
    length:number;
    lot:number;
    price:number;
    width:number;
    section_assigned:Section;
    product_type:string;
    container_type:string;

}
