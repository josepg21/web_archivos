package com.archivo.backend.services;

import com.archivo.backend.dtos.DocumentDto;
import com.archivo.backend.entities.Document;
import com.archivo.backend.repositories.DocumentRepository;
import com.archivo.backend.utils.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    public Document saveDocument(DocumentDto documentDto) {
        Document document = new Document();
        document.setNumeroHistoria(documentDto.getNumeroHistoria());
        document.setUsuario(documentDto.getUsuario());
        document.setFechaCarga(documentDto.getFechaCarga());
        document.setNombreDocumento(documentDto.getNombreDocumento());
        document.setFechaDocumento(documentDto.getFechaDocumento());
        document.setNombrePaciente(documentDto.getNombrePaciente());
        return documentRepository.save(document);
    }

    public List<Document> getAllDocuments() {
        return documentRepository.findAll();
    }

    public void importDocumentsFromExcel(MultipartFile file) throws IOException {
        List<DocumentDto> documentDtos = ExcelUtil.parseExcelFile(file);
        for (DocumentDto documentDto : documentDtos) {
            saveDocument(documentDto);
        }
    }

    public byte[] exportDocumentsToExcel() {
        List<Document> documents = getAllDocuments();
        // Make sure ExcelUtil.exportToExcel returns a byte[] representing the Excel file
        return ExcelUtil.exportToExcel(documents);
    }
}