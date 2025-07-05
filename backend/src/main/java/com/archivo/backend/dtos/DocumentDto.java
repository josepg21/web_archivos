package com.archivo.backend.dtos;

import java.time.LocalDate;

public class DocumentDto {
    private String numeroHistoria;
    private String usuario;
    private LocalDate fechaCarga;
    private String nombreDocumento;
    private LocalDate fechaDocumento;
    private String nombrePaciente;

    public DocumentDto() {
    }

    public DocumentDto(String numeroHistoria, String usuario, LocalDate fechaCarga, String nombreDocumento, LocalDate fechaDocumento, String nombrePaciente) {
        this.numeroHistoria = numeroHistoria;
        this.usuario = usuario;
        this.fechaCarga = fechaCarga;
        this.nombreDocumento = nombreDocumento;
        this.fechaDocumento = fechaDocumento;
        this.nombrePaciente = nombrePaciente;
    }

    public String getNumeroHistoria() {
        return numeroHistoria;
    }

    public void setNumeroHistoria(String numeroHistoria) {
        this.numeroHistoria = numeroHistoria;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public LocalDate getFechaCarga() {
        return fechaCarga;
    }

    public void setFechaCarga(LocalDate fechaCarga) {
        this.fechaCarga = fechaCarga;
    }

    public String getNombreDocumento() {
        return nombreDocumento;
    }

    public void setNombreDocumento(String nombreDocumento) {
        this.nombreDocumento = nombreDocumento;
    }

    public LocalDate getFechaDocumento() {
        return fechaDocumento;
    }

    public void setFechaDocumento(LocalDate fechaDocumento) {
        this.fechaDocumento = fechaDocumento;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }
}