import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PopularplansComponent } from './popularplans.component';

describe('PopularplansComponent', () => {
  let component: PopularplansComponent;
  let fixture: ComponentFixture<PopularplansComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PopularplansComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PopularplansComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
