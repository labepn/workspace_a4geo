import { TestBed } from '@angular/core/testing';

import { ZemljisteService } from './zemljiste.service';

describe('ZemljisteService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ZemljisteService = TestBed.get(ZemljisteService);
    expect(service).toBeTruthy();
  });
});
