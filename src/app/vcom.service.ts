import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class VcomService {

  private baseUrl = 'http://localhost:9090/customers';

  constructor(private http: HttpClient) { }

  getCustomerById(customerId: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${customerId}`);
  }

  getServicesById(serviceId:number): Observable<any> {
    return this.http.get(`${this.baseUrl}/services/${serviceId}`);
  }

  getAllServices():Observable<any>
  {
    return this.http.get(`${this.baseUrl}/services`);
  }

}
