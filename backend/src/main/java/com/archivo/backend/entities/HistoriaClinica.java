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
@Table(name = "historia_clinica")
public class HistoriaClinica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_historia_clinica")
    private Integer idHistoriaClinica;

    @Column(name = "numero_historia")
    private String numeroHistoria;

    @Column(name = "nombre_paciente")
    private String nombrePaciente;

    @Column(name = "nombre_documento")
    private String nombreDocumento;

    @Column(name = "fecha_documento")
    private LocalDate fechaDocumento;

    @Column(name = "fecha_carga")
    private LocalDateTime fechaCarga;

    @Column(name = "personal")
    private String personal;

    @ManyToOne
    @JoinColumn(name = "caja_id")
    private Caja caja;
}