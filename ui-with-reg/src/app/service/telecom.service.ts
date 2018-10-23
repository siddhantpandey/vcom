import { Injectable } from '@angular/core';
import { User } from '../model/user';
import {Http,RequestOptions, Headers, Response} from '@angular/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Plan } from '../model/plan';

@Injectable({
  providedIn: 'root'
})
export class TelecomService {
  baseUrl:string;

  constructor(private http:Http) 
  { 
    this.baseUrl="http://localhost:9090/customers/"

  }





  getJsonContentTypeHeader():RequestOptions
  {
    const headers=new Headers();
    headers.append('Content-Type','application/json');
    return new RequestOptions({headers:headers});
  }
  getBaseUrlForPlan():string
  {
    return this.baseUrl+"register";
  }
  getBaseUrlForAdd():string
  {
    return this.baseUrl+"register";
  }
  getBaseUrlForAddPlan():string{
    return this.baseUrl+"services";
  }
  getBaseUrlForCustomerByEmail(emid:string):string{
    return this.baseUrl+"emailId/"+emid;
  }

  add(user:User):Observable<User>
  {
    return this.http.post(this.getBaseUrlForAdd(),JSON.stringify(user),this.getJsonContentTypeHeader()).pipe(map(data=>data.json()));
  }
  addPlan(plan:Plan):Observable<Plan>{
    console.log(plan);
    return this.http.post(this.getBaseUrlForAddPlan(),JSON.stringify(plan),this.getJsonContentTypeHeader()).pipe(map(data=>data.json()));
  }
  getCustomerByEmailId(emid:string):Observable<User>{
   return this.http.get(this.getBaseUrlForCustomerByEmail(emid)).pipe(map(data=>data.json()));
  }   
    
}
