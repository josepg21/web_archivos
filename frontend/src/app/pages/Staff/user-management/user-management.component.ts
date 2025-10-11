import { Component , OnInit} from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AuthService } from '../../../core/services/auth.service';

@Component({
  selector: 'app-user-management',
  templateUrl: './user-management.component.html',
  styleUrls: ['./user-management.component.css'],
  standalone: true,
  imports: [CommonModule, FormsModule]
})
export class UserManagementComponent implements OnInit{


  mostrarModalRegistro = false;
  nuevoUsuario: any = {
    usuario: '',
    contrasena: '', 
    nombreCompleto: '',
    dni: '',
    rol: '',
    sede: ''
  };

  roles: any[] = [];

  constructor(private authService: AuthService) {}

  ngOnInit() {
  this.authService.getRoles().subscribe(data => {
    this.roles = data;
    console.log('Roles cargados:', this.roles); // <-- Verifica en consola
  });
}

  abrirModalRegistro() {
    this.mostrarModalRegistro = true;
  }

  cerrarModalRegistro() {
    this.mostrarModalRegistro = false;
    this.nuevoUsuario = { usuario: '', contrasena: '', nombreCompleto: '', dni: '', rol: '', sede: '' };
  }

  registrarUsuario() {
    alert('Funcionalidad de registrar aún no implementada');}
  

  eliminarSeleccionados() {
    alert('Funcionalidad de eliminar aún no implementada');}

  modificarSeleccionados() {
    alert('Funcionalidad de deshabilitar aún no implementada');

  }
}
