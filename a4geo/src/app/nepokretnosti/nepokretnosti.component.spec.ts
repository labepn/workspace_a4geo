import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NepokretnostiComponent } from './nepokretnosti.component';

describe('NepokretnostiComponent', () => {
  let component: NepokretnostiComponent;
  let fixture: ComponentFixture<NepokretnostiComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NepokretnostiComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NepokretnostiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
