package com.archivo.backend.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.archivo.backend.dtos.DocumentDto;
import com.archivo.backend.entities.Document;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Component
public class ExcelUtil {

    public void exportToExcel(List<DocumentDto> documentList, String filePath) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Documents");

        // Create header row
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Número de Historia");
        headerRow.createCell(1).setCellValue("Usuario");
        headerRow.createCell(2).setCellValue("Fecha de Carga");
        headerRow.createCell(3).setCellValue("Nombre del Documento");
        headerRow.createCell(4).setCellValue("Fecha del Documento");
        headerRow.createCell(5).setCellValue("Nombre del Paciente");

        // Fill data
        int rowNum = 1;
        for (DocumentDto document : documentList) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(document.getNumeroHistoria());
            row.createCell(1).setCellValue(document.getUsuario());
            row.createCell(2).setCellValue(document.getFechaCarga().toString());
            row.createCell(3).setCellValue(document.getNombreDocumento());
            row.createCell(4).setCellValue(document.getFechaDocumento().toString());
            row.createCell(5).setCellValue(document.getNombrePaciente());
        }

        // Write to file
        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
        } finally {
            workbook.close();
        }
    }

    public static byte[] exportToExcel(List<Document> documents) {
        throw new UnsupportedOperationException("Unimplemented method 'exportToExcel'");
    }

    public static List<DocumentDto> parseExcelFile(MultipartFile file) {
        throw new UnsupportedOperationException("Unimplemented method 'parseExcelFile'");
    }

    // Additional methods for reading from Excel can be added here
}