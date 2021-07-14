import { TestBed } from '@angular/core/testing';

import { GeoportalmkService } from './geoportalmk.service';

describe('GeoportalmkService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: GeoportalmkService = TestBed.get(GeoportalmkService);
    expect(service).toBeTruthy();
  });
});
