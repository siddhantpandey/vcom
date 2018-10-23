import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-popularplans',
  templateUrl: './popularplans.component.html',
  styleUrls: ['./popularplans.component.css']
})
export class PopularplansComponent implements OnInit {
 
  plan1: string;
  plan2: string;
  plan3: string;
  plan4: string;

  price1: string;
  price2: string;
  price3: string;
  price4: string;

  constructor() {
    
  }

  ngOnInit() {
    this.plan1 = "Voice";
    this.plan2 = "Data";
    this.plan3 = "Postpaid";
    this.plan4 = "Prepaid";
    this.price1 = "299";
    this.price2 = "499";
    this.price3 = "399";
    this.price4 = "299";
  }
}
