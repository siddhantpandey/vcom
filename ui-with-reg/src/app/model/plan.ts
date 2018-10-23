import { User } from "./user";


export class Plan {

    
    private serviceId:number;
    

	
	private services:string;
	
	
	private plans:string;
	
	
	private packages:string;

	private dateOfActivation:String;

    private customerId:number;
    
    public setDate(dateOfActivation:String){
        this.dateOfActivation=dateOfActivation;
    }
    public setCustomerId(user:number){
        this.customerId=user;
    }
  
}
