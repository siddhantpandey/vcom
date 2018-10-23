import { Component, OnInit } from "@angular/core";
import { TelecomService } from '../service/telecom.service';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { User } from '../model/user';
@Component({
  selector: "app-register",
  templateUrl: "./register.component.html",
  styleUrls: ["./register.component.css"]
})
export class RegisterComponent implements OnInit {
  loginImg: string;
  logoImg: string;
  user:User;
  id:string;
  constructor(private router: Router,private ar:ActivatedRoute,private ts:TelecomService) {
    this.loginImg = "/assets/login.jpeg";
    this.logoImg = "/assets/logo.jpg";
  }

  ngOnInit() 
  {
    this.user=new User();
  }
  save()
  {
    this.id=this.user.emailId;
    this.ts.add(this.user).subscribe(data=>
      {
        this.router.navigate(['/plans',this.id]);
      },
      error=>
      {
        alert("some error happened");
      })
  }
}
