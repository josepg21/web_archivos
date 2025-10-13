package com.archivo.backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NuevoUsuarioDto {
    private String usuario;
    private String contraseña;
    private String nombreCompleto;
    private String dni;
    private String rol;
    private String sede;
}