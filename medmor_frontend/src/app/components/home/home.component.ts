import { Component, OnInit } from '@angular/core';
import { faFacebook } from '@fortawesome/free-brands-svg-icons';
import { faTwitter } from '@fortawesome/free-brands-svg-icons';
import { faInstagram } from '@fortawesome/free-brands-svg-icons';
import { faYoutube } from '@fortawesome/free-brands-svg-icons';
import { faAppStore } from '@fortawesome/free-brands-svg-icons';
import {ProductService} from '../../services/product.service';

import {SectionService} from '../../services/section.service';
import {UserService} from '../../services/user.service';






@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  facebook = faFacebook;
  twitter = faTwitter;
  instagram = faInstagram;
  youtube = faYoutube;
  appStore = faAppStore;

  countProducts:number;
  countSections:number;
  countUsers:number;

  constructor(private productService:ProductService , private sectionService:SectionService,private userService:UserService ) { }

  ngOnInit(): void {
    this.productService.getAll().
    subscribe( (promise:any)=>{
      this.countProducts = promise.length;
      
  });

  this.sectionService.getAll().
  subscribe( (promise:any)=>{
    this.countSections = promise.length;
    
});

this.userService.getAll().
subscribe( (promise:any)=>{
  this.countUsers = promise.length;
  
});

  }




}
