import { Component } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { ChangeDetectionStrategy } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { AuthService } from '../../core/services/auth.service';



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

  constructor(private fb: FormBuilder, private authService: AuthService) {
    this.loginForm = this.fb.group({
      userName: ['', Validators.required],
      password: ['', Validators.required]
    });
  }

  onSubmit(): void {
    if (this.loginForm.valid) {
      const { userName, password } = this.loginForm.value; // ← AQUÍ
  
      this.authService.login(userName, password).subscribe({
        next: (token: string) => {
          localStorage.setItem('token', token); // puedes manejar redirección después
          console.log('Login exitoso');
        },
        error: err => {
          alert('Credenciales incorrectas');
          console.error(err);
        }
      });
    }
  }
}