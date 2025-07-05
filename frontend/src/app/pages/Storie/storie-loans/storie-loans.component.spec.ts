import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StorieLoansComponent } from './storie-loans.component';

describe('StorieLoansComponent', () => {
  let component: StorieLoansComponent;
  let fixture: ComponentFixture<StorieLoansComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [StorieLoansComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(StorieLoansComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
