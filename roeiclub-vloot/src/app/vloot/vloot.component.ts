import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { VlootService } from './vloot.service';
import { Vloot } from './vloot';
import { Palen } from './palen';

@Component({
  selector: 'roeiclub-vloot',
  templateUrl: './vloot.component.html',

})

export class VlootComponent implements OnInit{
  vlootArray : Vloot[] = new Array();

  constructor(private vlootService : VlootService) { }

  getVloot() {
    this.vlootService.getVloot()
      .subscribe(data => {
        this.vlootArray = data;
      });

      console.log(this.vlootArray)
  }

  ngOnInit() {
    this.getVloot();
  }

}
