import { TestBed } from '@angular/core/testing';

import { NotLoggedRouteGuardService } from './not-logged-route-guard.service';

describe('NotLoggedRouteGuardService', () => {
  let service: NotLoggedRouteGuardService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(NotLoggedRouteGuardService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
