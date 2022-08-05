import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HomeComponent} from '../app/components/home/home.component';
import {LoginComponent} from '../app/components/login/login.component';
import {ProductComponent} from '../app/components/product/product.component';
import {RegisterComponent} from '../app/components/register/register.component';
import {SectionComponent} from '../app/components/section/section.component';
import { CreateProductComponent } from './components/product/create-product/create-product.component';

const routes: Routes = [
  {path:'home', component:HomeComponent},
  {path:'', component:HomeComponent},
  {path:'login', component:LoginComponent},
  {path:'product', component:ProductComponent},
  {path:'register', component:RegisterComponent},
  {path:'section', component:SectionComponent},
  {path:'create_product', component:CreateProductComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
