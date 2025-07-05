import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StaffregComponent } from './staffreg.component';

describe('StaffregComponent', () => {
  let component: StaffregComponent;
  let fixture: ComponentFixture<StaffregComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [StaffregComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(StaffregComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
