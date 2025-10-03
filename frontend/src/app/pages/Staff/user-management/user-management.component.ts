import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-user-management',
  templateUrl: './user-management.component.html',
  styleUrls: ['./user-management.component.css'],
  standalone: true,
  imports: [CommonModule, FormsModule]
})
export class UserManagementComponent {
  usuarios = [
    { dni: '12345678', nombreCompleto: 'Juan Pérez', rol: 'Asitente', sede: 'Clinica San Juan'},
    { dni: '87654321', nombreCompleto: 'Ana Gómez', rol: 'Administrador', sede: 'Clinica Surco'}
  ];

  mostrarModalRegistro = false;
  nuevoUsuario: any = {
    usuario: '',
    contrasena: '', 
    nombreCompleto: '',
    dni: '',
    rol: '',
    sede: ''
  };

  abrirModalRegistro() {
    this.mostrarModalRegistro = true;
  }

  cerrarModalRegistro() {
    this.mostrarModalRegistro = false;
    this.nuevoUsuario = { usuario: '', contrasena: '', nombreCompleto: '', dni: '', rol: '', sede: '' };
  }

  registrarUsuario() {
    this.usuarios.push({
      dni: this.nuevoUsuario.dni,
      nombreCompleto: this.nuevoUsuario.nombreCompleto,
      rol: this.nuevoUsuario.rol,
      sede: this.nuevoUsuario.sede
    });
    this.cerrarModalRegistro();
  }

  eliminarSeleccionados() {
    alert('Funcionalidad de eliminar aún no implementada');}

  deshabilitarSeleccionados() {
    alert('Funcionalidad de deshabilitar aún no implementada');

  }
}
