import { Component, OnInit } from "@angular/core";

@Component({
  selector: "app-login",
  templateUrl: "./login.component.html",
  styleUrls: ["./login.component.css"]
})
export class LoginComponent implements OnInit {
  loginImg: string;
  logoImg: string;
  constructor() {
    this.loginImg = "/assets/login.jpeg";
    this.logoImg = "/assets/logo.jpg";
  }

  ngOnInit() {}
}
