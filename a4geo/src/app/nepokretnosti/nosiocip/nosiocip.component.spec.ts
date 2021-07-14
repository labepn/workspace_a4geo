import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NosiocipComponent } from './nosiocip.component';

describe('NosiocipComponent', () => {
  let component: NosiocipComponent;
  let fixture: ComponentFixture<NosiocipComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NosiocipComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NosiocipComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
