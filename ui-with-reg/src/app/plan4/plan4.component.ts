import { Component, OnInit } from "@angular/core";
import { ActivatedRoute } from "@angular/router";

@Component({
  selector: "app-plan4",
  templateUrl: "./plan4.component.html",
  styleUrls: ["./plan4.component.css"]
})
export class Plan4Component implements OnInit {
  plan4: string;
  price4: string;
  constructor(private act: ActivatedRoute) {}

  ngOnInit() {
    this.act.params.subscribe(data => {
      this.plan4 = data["plan4"];
      this.price4 = data["price4"];
      console.log(this.plan4);
    });
  }
}
