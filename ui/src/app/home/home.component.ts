import { Component, OnInit } from "@angular/core";

@Component({
  selector: "app-home",
  templateUrl: "./home.component.html"
})
export class HomeComponent implements OnInit {
  slideshow: string;

  constructor() {
    this.slideshow = "/assets/slideshow.jpeg";
  }

  ngOnInit() {}
}
