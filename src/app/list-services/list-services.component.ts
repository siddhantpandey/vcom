import { Component, OnInit } from '@angular/core';
import { VcomService } from '../vcom.service';
import { ServicesBought } from '../ServicesBought.model';
import {Observable} from 'rxjs';
import { Customer } from '../Customer.model';
import {  Router, ActivatedRoute } from '@angular/router';
import { Bills } from '../Bills.model';
import { Services } from '../Services.enum';
import { Months } from '../Months.enum';

@Component({
  selector: 'app-list-services',
  templateUrl: './list-services.component.html',
  styleUrls: ['./list-services.component.css']
})
export class ListServicesComponent implements OnInit {

  customerId:number;
  bills: Observable<Bills[]>;
  servicelist:ServicesBought[];
  customers:Observable<Customer>;
  showdetails:boolean

  months: any[] = [
    { id: 0, name: 'SELECT A MONTH' },
    { id: 1, name: 'January' },
    { id: 2, name: 'February' },
    { id: 3, name: 'March' },
    { id: 4, name: 'April' },
    { id: 5, name: 'May' },
    { id: 6, name: 'June' },
    { id: 7, name: 'July' },
    { id: 8, name: 'August' },
    { id: 9, name: 'September' },
    { id: 10, name: 'October' },
    { id: 11, name: 'November' },
    { id: 12, name: 'December' }
  ];


  constructor(private vcomService:VcomService, private router:Router, private route:ActivatedRoute) {
   
   }

  ngOnInit() {
    this.customerId=1
    this.showdetails=false
    this.getCustomerById()
    this.getAllServices()
  }

  private getAllServices()
  {
    this.vcomService.getAllServices()
    .subscribe(servicelist => this.servicelist = servicelist);
  }

  private getCustomerById()
  {
    this.vcomService.getCustomerById(this.customerId)
    .subscribe(customers => this.customers = customers);
  }

  navigate(billId:number,customerId:number,serviceId:number)
  {
    this.router.navigate(['/billing',billId,customerId,serviceId]);
  }

  selectOption(id: number) {
    if(this.months[id].name!="SELECT A MONTH")
    {
      this.showdetails=true;
      this.vcomService.getBillsByMonth(this.customerId,this.months[id].name)
      .subscribe(bills => this.bills = bills);
    }
    else
    {
      this.showdetails=false;
    }
  }

  getdesc(serviceId:number)
  {
      for(let service of this.servicelist)
      {
        if(service.serviceId==serviceId){
          return service.services
        }
      }
  }

  getplans(serviceId:number)
  {
    for(let service of this.servicelist)
    {
      if(service.serviceId==serviceId){
        return service.plans
      }
    }
  }

  checkdisable(bill:Bills)
  {
    console.log(bill.status)
    if(bill.status==true)
    {
      return true
    }
    else
    return false
  }


}
