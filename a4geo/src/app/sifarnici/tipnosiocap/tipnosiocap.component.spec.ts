import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TipnosiocapComponent } from './tipnosiocap.component';

describe('VrstapravaComponent', () => {
  let component: TipnosiocapComponent;
  let fixture: ComponentFixture<TipnosiocapComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TipnosiocapComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TipnosiocapComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
