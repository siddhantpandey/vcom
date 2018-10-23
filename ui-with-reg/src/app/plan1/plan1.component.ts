import { Component, OnInit } from "@angular/core";
import { ActivatedRoute } from "@angular/router";

@Component({
  selector: "app-plan1",
  templateUrl: "./plan1.component.html",
  styleUrls: ["./plan1.component.css"]
})
export class Plan1Component implements OnInit {
  plan1: string;
  price1: string;
  constructor(private act: ActivatedRoute) {}

  ngOnInit() {
    this.act.params.subscribe(data => {
      this.plan1 = data["plan1"];
      this.price1 = data["price1"];

      console.log(this.plan1);
    });
  }
}
