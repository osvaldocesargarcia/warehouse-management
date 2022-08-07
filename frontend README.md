# warehouse-management frontend (case study)

<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#problem-description">Problem Description</a></li>
        <li><a href="#application-requirements">Application requirements</a></li>
      </ul>
    </li>
    <li>
      <a href="#frontend-solution">Frontend Solution</a>
      </li>
   
  </ol>
</details>

<!-- ABOUT THE PROJECT -->
## About The Project
The present project is a case study to test my skills as a fullstack developer. It is a web application programmed with modern technologies: Angular and Spring Boot. Nowadays these frameworks are very popular in web programmation branch and the combination of both is very common. In the following section I provide details of the problem.

### Problem Description
MEDMOR SA, a company specialized in the sale and distribution of hardware products, wants to control and optimize its inventory processes. To do so, it needs to implement an API that allows it to manage all areas and products in the warehouse. The warehouse has sections. Each section has a size in square meters, the type of product destined to it, which can be Electrical Materials, Equipment, Locksmith, Tools and Plumbing. Each product has a size, color, price, if it is fragile, type of packaging (Cardboard, Plastic, Glass, Nylon) and lot. To operate the system, two main roles are defined: Administrator and Operator. The Administrator has access to the entire system, while the Operator will be restricted to delete sections.

### Application requirements
#### Spring Boot API
Implement an API in Spring Boot that allows to fulfill the following requirements: 
##### 1.1- Add a given quantity of a product to a section.
##### 1.2- Create/edit/delete a new section in a warehouse. Only sections that do not contain products can be deleted. 
##### 1.3- List product information, and perform filtering operation by: section, lot, fragility, color, price range, 
##### and type of packaging. 

#### Angular
Implement a visual interface that can be integrated with the previously implemented functionalities and that allows the following requirements to be met: 
##### 2.1- Allow the reuse of the most used code snippets in the templates. 
##### 2.2- Ensure the adaptation to different devices using Bootstrap 5.0 .
##### 2.3- Apply the necessary validations in the data entry. 
##### 2.4- Handle security aspects if necessary. 

#### Spring JPA
Develop an adequate relational database design that supports the above mentioned problems. In addition, the optimization of the requests must be guaranteed by relying on the ORM and complying with the following indications: 
##### 3.1- It must guarantee on-demand loading of entity dependencies unless for specific reasons a decision to the contrary is made. 
##### 3.2- Avoid the use of native queries. 
##### 3.3- Avoid obtaining unnecessary information by using data access object mapping techniques such as projections or DTOs. 

 ## Frontend Solution
 
 To adjust the frontend to the backend structure 
 
 The result obtained is an application that allows the consultation and management of sections and products in the warehouse, with navigation and user control. The application is fully responsive, based on Bootstrap 5 css framework and soft-ui. 
  Services were created to make requests to the backend and classes that fit the model of the response obtained. The data inputs were validated in all forms using Angular's FormGroup and its controllers. Pipes and customized pipes were used to display information correctly. 
  Navigation between components was enabled and components were reused in different functionalities such as "CreateProduct" for creating and updating products. A service was created for the transport of data between components.
  The following are some examples of the above:
  
  
  #### Model: Section
  ```
 export class Section {
    
    section_id:number;
    product_type:string;
    length:number;
    width:number;
    
}
  ```
  
  #### Service: Section
  ```
  export class SectionService {

   private baseURL = "http://localhost:8080/api/medmor/section"
   
     constructor(private http:HttpClient) {    }
   
   getAll(){
     return this.http.get(this.baseURL);
   }

   getById(id:number){
     return this.http.get( 'http://localhost:8080/api/medmor/getsection?id='+id);
   }
   
   create(section:Section){
        return this.http.post('http://localhost:8080/api/medmor/section',section);
     }

   delete(id:number){
       return this.http.delete('http://localhost:8080/api/medmor/section/'+id);
   }
}
```

#### Routes defined with RouteGuardServices
  ```
const routes: Routes = [
  {path:'home', component:HomeComponent},
  {path:'', component:HomeComponent},
  {path:'login', component:LoginComponent,canActivate:[NotLoggedRouteGuardService] },
  {path:'product', component:ProductComponent, canActivate:[RouteGuardService]},
  {path:'register', component:RegisterComponent, canActivate:[NotLoggedRouteGuardService]},
  {path:'section', component:SectionComponent, canActivate:[RouteGuardService]},
  {path:'create_product', component:CreateProductComponent, canActivate:[RouteGuardService]},
  {path:'update_product/:id/:type/:section/:lot/:length/:width/:price/:color/:container', component:CreateProductComponent, canActivate:[RouteGuardService]},
  {path:'create_section', component:CreateSectionComponent, canActivate:[RouteGuardService]},
];
  ```

 
 #### Customized pipe
  ```
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
        } }}
  ```
  
  #### SharedService for data transfer between components (Example login -> navbar)
  ```
  export class SharedService {
    
    private emitChangeSource = new Subject<any>();
   
    changeEmitted$ = this.emitChangeSource.asObservable();
    productChangeEmitted$ = this.emitChangeSource.asObservable();
    
    emitChange(change: any) {
        this.emitChangeSource.next(change);
    }

    productEmitChange(change: any) {
        this.emitChangeSource.next(change);
    }
}
  ```
