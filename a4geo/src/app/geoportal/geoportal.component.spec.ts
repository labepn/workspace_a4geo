import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GeoportalComponent } from './geoportal.component';

describe('GeoportalComponent', () => {
  let component: GeoportalComponent;
  let fixture: ComponentFixture<GeoportalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GeoportalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GeoportalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
