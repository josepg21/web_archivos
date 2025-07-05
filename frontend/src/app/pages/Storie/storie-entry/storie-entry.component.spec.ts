import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StorieEntryComponent } from './storie-entry.component';

describe('StorieEntryComponent', () => {
  let component: StorieEntryComponent;
  let fixture: ComponentFixture<StorieEntryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [StorieEntryComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(StorieEntryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
