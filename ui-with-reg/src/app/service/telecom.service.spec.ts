import { TestBed, inject } from '@angular/core/testing';

import { TelecomService } from './telecom.service';

describe('TelecomService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [TelecomService]
    });
  });

  it('should be created', inject([TelecomService], (service: TelecomService) => {
    expect(service).toBeTruthy();
  }));
});
