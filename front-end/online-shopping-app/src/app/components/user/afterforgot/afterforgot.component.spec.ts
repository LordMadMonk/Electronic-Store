import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AfterforgotComponent } from './afterforgot.component';

describe('AfterforgotComponent', () => {
  let component: AfterforgotComponent;
  let fixture: ComponentFixture<AfterforgotComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AfterforgotComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AfterforgotComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
