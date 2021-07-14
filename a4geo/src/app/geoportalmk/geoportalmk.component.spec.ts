import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GeoportalmkComponent } from './geoportalmk.component';

describe('GeoportalmkComponent', () => {
  let component: GeoportalmkComponent;
  let fixture: ComponentFixture<GeoportalmkComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GeoportalmkComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GeoportalmkComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
