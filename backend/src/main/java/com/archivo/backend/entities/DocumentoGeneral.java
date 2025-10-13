package com.archivo.backend.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "documento_general")
public class DocumentoGeneral {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "caja_id")
    private Caja caja;

    @Column(name = "tipo_documento")
    private String tipoDocumento;

    @Column(name = "nombre_documento")
    private String nombreDocumento;

    @Column(name = "fecha_documento")
    private LocalDate fechaDocumento;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "ruta_archivo")
    private String rutaArchivo;

    @ManyToOne
    @JoinColumn(name = "subido_por")
    private NuevoUsuario subidoPor;

    @Column(name = "fecha_subida")
    private LocalDateTime fechaSubida;
}