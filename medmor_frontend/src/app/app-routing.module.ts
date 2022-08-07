import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HomeComponent} from '../app/components/home/home.component';
import {LoginComponent} from '../app/components/login/login.component';
import {ProductComponent} from '../app/components/product/product.component';
import {RegisterComponent} from '../app/components/register/register.component';
import {SectionComponent} from '../app/components/section/section.component';
import {CreateSectionComponent} from '../app/components/section/create-section/create-section.component';
import { CreateProductComponent } from './components/product/create-product/create-product.component';
import {RouteGuardService} from '../app/services/route-guard.service';
import {NotLoggedRouteGuardService} from '../app/services/not-logged-route-guard.service';



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

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
