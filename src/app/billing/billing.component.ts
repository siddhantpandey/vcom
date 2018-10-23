import { Component, OnInit, Input } from '@angular/core';
import { VcomService } from '../vcom.service';
import { Observable } from 'rxjs';
import {Customer} from '../Customer.model'
import { ServicesBought } from '../ServicesBought.model';
import { ActivatedRoute } from '@angular/router';
import { Months } from '../Months.enum';
import { Bills } from '../Bills.model';

@Component({
  selector: 'app-billing',
  templateUrl: './billing.component.html',
  styleUrls: ['./billing.component.css']
})
export class BillingComponent implements OnInit {

  customer:Customer
  customerId:any
  services:ServicesBought
  billId:any
  bill:Bills;
  serviceId:any

  constructor(private vcomService:VcomService , private route:ActivatedRoute) { 
    this.billId=this.route.snapshot.paramMap.get('billId');
    this.customerId=this.route.snapshot.paramMap.get('customerId');
    this.serviceId=this.route.snapshot.paramMap.get('serviceId');    
  }

  ngOnInit() {
    
    this.CustomerDetails()
    this.getBillById()
    this.ServiceDetailsById()
  }

  private CustomerDetails() {

    this.vcomService.getCustomerById(this.customerId)
      .subscribe(customer => this.customer = customer);
  }

  private getBillById() {

    this.vcomService.getBillById(this.billId)
      .subscribe(bill => this.bill = bill); 
  }

  ServiceDetailsById() {
    this.vcomService.getServicesById(this.serviceId)
      .subscribe(services => this.services = services);
  }

 

  settime()
  {
    var today = new Date();
    var date = today.getDate()+'-'+(today.getMonth()+1)+'-'+today.getFullYear();
    return date;
  }
  

}
