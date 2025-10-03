import { Component } from '@angular/core';
import { RouterModule, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-navigation',
  standalone: true, // ✅ Esto habilita el uso de imports dentro del componente
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css'],
  imports: [RouterModule, RouterOutlet] // ✅ Esto ya está bien
})
export class NavigationComponent {}
