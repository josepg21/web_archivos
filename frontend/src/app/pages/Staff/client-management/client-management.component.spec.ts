import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserClientComponent } from './client-management.component';

describe('StafflistComponent', () => {
  let component: UserClientComponent;
  let fixture: ComponentFixture<UserClientComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UserClientComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UserClientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
