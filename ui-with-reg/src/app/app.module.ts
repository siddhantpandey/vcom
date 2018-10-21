import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";

import { AppComponent } from "./app.component";
import { HomeComponent } from "./home/home.component";
import { LoginComponent } from "./login/login.component";
import { RegisterComponent } from "./register/register.component";

import { FormsModule } from "@angular/forms";
import { RouterModule, Routes } from "@angular/router";
import { HttpModule } from "@angular/http";
import { LoginhomeComponent } from './loginhome/loginhome.component';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { PlansComponent } from './plans/plans.component';
import { BillingComponent } from './billing/billing.component';


const paths: Routes = [
  { path: "", component: LoginhomeComponent },
  { path: "home", component: HomeComponent },
  { path: "login", component: LoginComponent },
  { path: "register", component: RegisterComponent },
  { path: "billing", component: BillingComponent},
  { path: "billing/:serviceId/:customerId", component: BillingComponent},
  { path: "plans", component: PlansComponent }

];

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    RegisterComponent,
    LoginhomeComponent,
    PlansComponent,
    BillingComponent,
    
  ],
  imports: [
    BrowserModule,
    FormsModule,
    NgbModule,
    HttpModule,
    RouterModule.forRoot(paths)
  ],
  providers: [],

  bootstrap: [AppComponent]
})
export class AppModule {}
