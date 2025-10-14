import { Component } from '@angular/core';
import { RouterModule, RouterOutlet } from '@angular/router';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import {
  faUser,
  faUserTie,
  faMagnifyingGlass,
  faRightLeft,
  faRotateLeft,
  faFolder,
  faBoxArchive,
  faWarehouse,
  faLock,
  faRightFromBracket
} from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-navigation',
  standalone: true,
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css'],
  imports: [RouterModule, RouterOutlet, FontAwesomeModule],
})
export class NavigationComponent {
  // ✅ Íconos
  faUser = faUser;
  faUserTie = faUserTie;
  faMagnifyingGlass = faMagnifyingGlass;
  faRightLeft = faRightLeft;
  faRotateLeft = faRotateLeft;
  faFolder = faFolder;
  faBoxArchive = faBoxArchive;
  faWarehouse = faWarehouse;
  faLock = faLock;
  faRightFromBracket = faRightFromBracket;

  // ✅ Usuario simulado
  usuario: string = 'Victor Andres';

  // ✅ Método de cerrar sesión
  cerrarSesion() {
    console.log('Sesión cerrada');
    // Aquí pondrías tu lógica real: limpiar token, redirigir al login, etc.
  }
}
