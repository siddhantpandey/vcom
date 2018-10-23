import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';

import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { HttpModule } from '@angular/http';
import { LoginhomeComponent } from './loginhome/loginhome.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { PlansComponent } from './plans/plans.component';
import { BillingComponent } from './billing/billing.component';

import { AngularFontAwesomeModule } from 'angular-font-awesome';
import { Plan1Component } from './plan1/plan1.component';
import { Plan2Component } from './plan2/plan2.component';
import { Plan3Component } from './plan3/plan3.component';
import { Plan4Component } from './plan4/plan4.component';
import { PopularplansComponent } from './popularplans/popularplans.component';
import { UserProfileComponent } from './user-profile/user-profile.component';

const paths: Routes = [
  { path: '', component: HomeComponent },
  { path: 'home', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'billing', component: BillingComponent },
  { path: 'billing/:serviceId/:customerId', component: BillingComponent },
  { path: 'plans', component: PopularplansComponent },
  { path: 'plan1/:plan1/:price1', component: Plan1Component },
  { path: 'plan2/:plan2/:price2', component: Plan2Component },
  { path: 'plan3/:plan3/:price3', component: Plan3Component },
  { path: 'plan4/:plan4/:price4', component: Plan4Component },
  { path: 'plans/:id', component: PlansComponent },
  { path: 'profile', component: UserProfileComponent },
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
    Plan1Component,
    Plan2Component,
    Plan3Component,
    Plan4Component,
    PopularplansComponent,
    UserProfileComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    NgbModule,
    HttpModule,
    RouterModule.forRoot(paths),
    AngularFontAwesomeModule,
  ],
  providers: [],

  bootstrap: [AppComponent],
})
export class AppModule {}
