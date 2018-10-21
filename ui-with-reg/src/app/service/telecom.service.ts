import { Injectable } from '@angular/core';
import { User } from '../model/user';
import {Http,RequestOptions, Headers, Response} from '@angular/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
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
  getBaseUrlForAdd():string
  {
    return this.baseUrl+"register";
  }
  add(user:User):Observable<User>
  {
    return this.http.post(this.getBaseUrlForAdd(),JSON.stringify(user),this.getJsonContentTypeHeader()).pipe(map(data=>data.json()));
  }
}
