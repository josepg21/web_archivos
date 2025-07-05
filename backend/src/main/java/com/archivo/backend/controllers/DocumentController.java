package com.archivo.backend.controllers;

import com.archivo.backend.dtos.DocumentDto;
import com.archivo.backend.entities.Document;
import com.archivo.backend.services.DocumentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/documents")
public class DocumentController {

    private final DocumentService documentService;

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadDocument(@RequestBody DocumentDto documentDto) {
        documentService.saveDocument(documentDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Documento cargado exitosamente");
    }

    @GetMapping("/export")
    public ResponseEntity<byte[]> exportDocuments() {
        byte[] excelFile = documentService.exportDocumentsToExcel();
        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment; filename=documents.xlsx")
                .body(excelFile);
    }

    @PostMapping("/import")
    public ResponseEntity<String> importDocuments(@RequestParam("file") MultipartFile file) {
        try {
            documentService.importDocumentsFromExcel(file);
            return ResponseEntity.ok("Documentos importados exitosamente");
        } catch (java.io.IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al importar documentos: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Document>> getAllDocuments() {
        List<Document> documents = documentService.getAllDocuments();
        return ResponseEntity.ok(documents);
    }
}