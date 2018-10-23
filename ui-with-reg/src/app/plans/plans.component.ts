import { Component, OnInit } from '@angular/core';
import { Plan } from '../model/plan';
import { formatDate } from '@angular/common';
import { TelecomService } from '../service/telecom.service';
import { Router, ActivatedRoute } from '@angular/router';
import { User } from '../model/user';

@Component({
  selector: 'app-plans',
  templateUrl: './plans.component.html',
  styleUrls: ['./plans.component.css']
})
export class PlansComponent implements OnInit {

  plan:Plan;
  cid:string;
  id:string;

  user:User;
  user_got:User[];
  constructor(private ts:TelecomService, private router:Router, private art:ActivatedRoute) { 
   this.art.params.subscribe(params=>{
    this.id=params['id'];
    this.getCustomerByEmailId();
   });
  //window.alert(this.id);
  }
  
  save(cid:User){
    let d=new Date();
    let x:string;
    console.log(cid);     

    x=formatDate(d, 'yyyy-MM-dd', 'en-US', '+0530');
    this.plan.setDate(x);
    this.plan.setCustomer(cid);
    
    this.ts.addPlan(this.plan).subscribe(data=>
      {
        this.router.navigateByUrl("/?opt=a&id=");
      },
      error=>
      {
        alert("some error happened");
      })
  }
  getCustomerByEmailId(){
    this.ts.getCustomerByEmailId(this.id).subscribe(data=> this.user=data);
  }
  
  ngOnInit() {
    this.plan=new Plan();
  }

}
