import { Component, OnInit } from "@angular/core";
import { ActivatedRoute } from "@angular/router";

@Component({
  selector: "app-plan3",
  templateUrl: "./plan3.component.html",
  styleUrls: ["./plan3.component.css"]
})
export class Plan3Component implements OnInit {
  plan3: string;
  price3: string;
  constructor(private act: ActivatedRoute) {}

  ngOnInit() {
    this.act.params.subscribe(data => {
      this.plan3 = data["plan3"];
      this.price3 = data["price3"];
      console.log(this.plan3);
    });
  }
}
