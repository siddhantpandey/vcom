import { TestBed, inject } from '@angular/core/testing';

import { VcomService } from './vcom.service';

describe('VcomService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [VcomService]
    });
  });

  it('should be created', inject([VcomService], (service: VcomService) => {
    expect(service).toBeTruthy();
  }));
});
