import { Component, OnInit } from '@angular/core';
import { User } from '../model/user';
import { TelecomService } from '../service/telecom.service';
import { ActivatedRoute } from '@angular/router';
import { Plan } from '../model/plan';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css'],
})
export class UserProfileComponent implements OnInit {
  user: User;
  plans: Plan[];
  userLogo: string;

  constructor(telserv: TelecomService, activatedRoute: ActivatedRoute) {
    this.userLogo = 'assets/user.jpg';
  }

  ngOnInit() {}
}
