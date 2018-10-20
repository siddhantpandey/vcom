import { Component, OnInit } from '@angular/core';
import { VcomService } from '../vcom.service';
import { ServicesBought } from '../ServicesBought.model';
import {Observable} from 'rxjs';
import { Customer } from '../Customer.model';
import {  Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-list-services',
  templateUrl: './list-services.component.html',
  styleUrls: ['./list-services.component.css']
})
export class ListServicesComponent implements OnInit {

  customerId:number;
  services: Observable<ServicesBought[]>;
  servicelist:ServicesBought[];
  customers:Observable<Customer>;

  constructor(private vcomService:VcomService, private router:Router, private route:ActivatedRoute) {
   
   }

  ngOnInit() {
    this.customerId=1
    this.getAllServices()
    this.getCustomerById()
  }

  private getAllServices()
  {
    this.vcomService.getAllServices()
    .subscribe(services => this.services = services);
  }

  check(service)
  {
    if(service.customer.customerId==this.customerId)
    return true;
    else
    return false;
  }

  private getCustomerById()
  {
    this.vcomService.getCustomerById(this.customerId)
    .subscribe(customers => this.customers = customers);
  }

  navigate(serviceId:number,customerId:number)
  {
    this.router.navigate(['/billing',serviceId,customerId]);
  }

}
