import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SifarniciComponent } from './sifarnici.component';

describe('SifarniciComponent', () => {
  let component: SifarniciComponent;
  let fixture: ComponentFixture<SifarniciComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SifarniciComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SifarniciComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
