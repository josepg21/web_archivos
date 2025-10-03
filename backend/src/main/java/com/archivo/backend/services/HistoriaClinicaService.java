package com.archivo.backend.services;

import com.archivo.backend.dtos.HistoriaClinicaDto;
import com.archivo.backend.entities.HistoriaClinica;
import com.archivo.backend.repositories.HistoriaClinicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.List;

@Service
public class HistoriaClinicaService {

    @Autowired
    private HistoriaClinicaRepository historiaClinicaRepository;

    public HistoriaClinica saveDocument(HistoriaClinicaDto documentDto) {
        HistoriaClinica historia = new HistoriaClinica();
        historia.setNumeroHistoria(documentDto.getNumeroHistoria());
        historia.setPersonal(documentDto.getUsuario());
        historia.setFechaCarga(documentDto.getFechaCarga().atStartOfDay());
        historia.setNombreDocumento(documentDto.getNombreDocumento());
        historia.setFechaDocumento(documentDto.getFechaDocumento());
        historia.setNombrePaciente(documentDto.getNombrePaciente());
        return historiaClinicaRepository.save(historia);
    }

    public List<HistoriaClinica> getAllDocuments() {
        return historiaClinicaRepository.findAll();
    }
}