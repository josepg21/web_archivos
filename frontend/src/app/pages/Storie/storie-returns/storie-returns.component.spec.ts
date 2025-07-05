import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StorieReturnsComponent } from './storie-returns.component';

describe('StorieReturnsComponent', () => {
  let component: StorieReturnsComponent;
  let fixture: ComponentFixture<StorieReturnsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [StorieReturnsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(StorieReturnsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
