import { Component, OnInit } from "@angular/core";
import { ActivatedRoute } from "@angular/router";

@Component({
  selector: "app-plan2",
  templateUrl: "./plan2.component.html",
  styleUrls: ["./plan2.component.css"]
})
export class Plan2Component implements OnInit {
  plan2: string;
  price2: string;
  constructor(private act: ActivatedRoute) {}

  ngOnInit() {
    this.act.params.subscribe(data => {
      this.plan2 = data["plan2"];
      this.price2 = data["price2"];

      console.log(this.plan2);
    });
  }
}
