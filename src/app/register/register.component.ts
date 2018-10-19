import { Component, OnInit } from "@angular/core";

@Component({
  selector: "app-register",
  templateUrl: "./register.component.html",
  styleUrls: ["./register.component.css"]
})
export class RegisterComponent implements OnInit {
  loginImg: string;
  logoImg: string;
  constructor() {
    this.loginImg = "/assets/login.jpeg";
    this.logoImg = "/assets/logo.jpg";
  }

  ngOnInit() {}
}
