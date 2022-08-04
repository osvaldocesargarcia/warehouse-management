import { Component, OnInit } from '@angular/core';
import {SectionService} from '../../../services/section.service';
import {Section} from '../../../models/section';

@Component({
  selector: 'app-section-table',
  templateUrl: './section-table.component.html',
  styleUrls: ['./section-table.component.scss']
})
export class SectionTableComponent implements OnInit {

section_list:Section[];
constructor(private sectionService:SectionService) { }

ngOnInit(): void {
  this.sectionService.getAll().
  subscribe( (promise:any)=>{
    this.section_list = promise;
    console.log(this.section_list );
})
}

}
