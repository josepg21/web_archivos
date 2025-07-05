import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StorieSearchComponent } from './storie-search.component';

describe('StorieSearchComponent', () => {
  let component: StorieSearchComponent;
  let fixture: ComponentFixture<StorieSearchComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [StorieSearchComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(StorieSearchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
