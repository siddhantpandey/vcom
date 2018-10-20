import { Component, OnInit, Input } from '@angular/core';
import { VcomService } from '../vcom.service';
import { Observable } from 'rxjs';
import {Customer} from '../Customer.model'
import { ServicesBought } from '../ServicesBought.model';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-billing',
  templateUrl: './billing.component.html',
  styleUrls: ['./billing.component.css']
})
export class BillingComponent implements OnInit {

  serviceId:any
  customer:Customer
  customerId:any
  services:ServicesBought

  constructor(private vcomService:VcomService , private route:ActivatedRoute) { 

    this.serviceId=this.route.snapshot.paramMap.get('serviceId');
    this.customerId=this.route.snapshot.paramMap.get('customerId');

  }

  ngOnInit() {
    this.customerId=1
    this.CustomerDetails()
    this.ServiceDetailsById()
  }
  private CustomerDetails() {

    this.vcomService.getCustomerById(this.customerId)
      .subscribe(customer => this.customer = customer);
  }

  private ServiceDetailsById() {

    this.vcomService.getServicesById(this.serviceId)
      .subscribe(services => this.services = services);
      console.log(this.serviceId)
  }

  settime()
  {
    var today = new Date();
    var date = today.getDate()+'-'+(today.getMonth()+1)+'-'+today.getFullYear();
    return date;
  }
  

}
