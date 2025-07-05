import { Component } from '@angular/core';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatTableModule } from '@angular/material/table';

@Component({
  selector: 'app-storie-loans',
  imports: [MatTableModule, MatPaginatorModule],
  templateUrl: './storie-loans.component.html',
  styleUrl: './storie-loans.component.css'
})
export class StorieLoansComponent {

}
