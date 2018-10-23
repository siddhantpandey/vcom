import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { Plan4Component } from './plan4.component';

describe('Plan4Component', () => {
  let component: Plan4Component;
  let fixture: ComponentFixture<Plan4Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Plan4Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Plan4Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
