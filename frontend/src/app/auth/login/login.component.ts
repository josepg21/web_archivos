import { Component } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { ChangeDetectionStrategy } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { AuthService } from '../../core/services/auth.service';
import { Router } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';




@Component({
  selector: 'app-login',
  imports: [MatFormFieldModule, 
            MatInputModule, 
            MatButtonModule, 
            MatIconModule,
            ReactiveFormsModule,
            ],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class LoginComponent {
  loginForm: FormGroup;

  constructor(private fb: FormBuilder, private authService: AuthService, private snackBar: MatSnackBar,private router: Router) {
    this.loginForm = this.fb.group({
    usuario: ['', Validators.required],
    contraseña: ['', Validators.required]
    });
  }

  onSubmit() {
  const { usuario, contraseña } = this.loginForm.value;
  this.authService.login(usuario, contraseña).subscribe({
    next: (token) => {
      this.snackBar.open('¡Acceso exitoso!', '', { duration: 2000 });
      setTimeout(() => {
          localStorage.setItem('token', token); // puedes manejar redirección después
          console.log('Login exitoso');
          this.router.navigate(['/navigation']); // ← Aquí rediriges
      }, 1000);
    },
    error: (err) => {
      this.snackBar.open('Credenciales incorrectas', '', { duration: 2000 });
    }
  });
}}