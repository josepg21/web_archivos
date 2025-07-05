import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StorieMovesComponent } from './storie-moves.component';

describe('StorieMovesComponent', () => {
  let component: StorieMovesComponent;
  let fixture: ComponentFixture<StorieMovesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [StorieMovesComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(StorieMovesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
