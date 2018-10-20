import {Services} from './Services.enum'
import {Plans} from './Plans.enum'
import {Packages} from './Packages.enum'
import { Customer } from './Customer.model';

export class ServicesBought
{
    serviceId:number
    services:Services
    plans:Plans
    packages:Packages
    dateOfActivation:Date
    customer:Customer
}