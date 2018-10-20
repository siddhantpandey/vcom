import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";

@Component({
  selector: "app-login",
  templateUrl: "./login.component.html",
  styleUrls: ["./login.component.css"]
})
export class LoginComponent implements OnInit {
  loginImg: string;
  logoImg: string;
  constructor(private router: Router) {
    this.loginImg = "/assets/login.jpeg";
    this.logoImg = "/assets/logo.jpg";
  }

  ngOnInit() {}
}
