package com.archivo.backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NuevoClienteDto {
    private String razonSocial;
    private String ruc;
    private String direccion;
    private String contacto;
    private Integer correo;
    private Integer telefono;
    
}
