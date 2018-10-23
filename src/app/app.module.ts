import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";

import { AppComponent } from "./app.component";
import { HomeComponent } from "./home/home.component";
import { LoginComponent } from "./login/login.component";
import { RegisterComponent } from "./register/register.component";

import { FormsModule } from "@angular/forms";
import { RouterModule, Routes } from "@angular/router";
import { HttpModule } from "@angular/http";
import {HttpClientModule} from '@angular/common/http';
import { BillingComponent } from './billing/billing.component';
import { ListServicesComponent } from './list-services/list-services.component';

const paths: Routes = [
  { path: "", component: HomeComponent },
  { path: "login", component: LoginComponent },
  { path: "register", component: RegisterComponent },
  { path: "billing", component: BillingComponent},
  { path: "billing/:billId/:customerId/:serviceId", component: BillingComponent},
  { path: "list-services", component: ListServicesComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    RegisterComponent,
    BillingComponent,
    ListServicesComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    HttpClientModule,
    RouterModule.forRoot(paths)
  ],
  providers: [],

  bootstrap: [AppComponent]
})
export class AppModule {}
