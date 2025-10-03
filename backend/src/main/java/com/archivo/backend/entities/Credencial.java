package com.archivo.backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "credencial")
public class Credencial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "usuario", unique = true, nullable = false)
    private String usuario;

    @Column(name = "contraseña", nullable = false)
    private String contraseña;

    @Column(name = "activo")
    private Boolean activo = true;

    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    public Credencial(String usuario, String contraseña, Role role) {
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.role = role;
        this.activo = true;
    }
}