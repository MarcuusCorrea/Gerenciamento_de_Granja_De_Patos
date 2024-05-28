package granja.Patos.Gerenciamento.de.Patos.Service;

import granja.Patos.Gerenciamento.de.Patos.Model.Pato;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class RelatorioExcelService {

    public ByteArrayInputStream gerarRelatorioDePatos(List<Pato> patos) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Patos");

        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("ID");
        header.createCell(1).setCellValue("Nome");
        header.createCell(2).setCellValue("Status");
        header.createCell(3).setCellValue("Valor");

        int rowIdx = 1;
        for (Pato pato : patos) {
            Row row = sheet.createRow(rowIdx++);
            row.createCell(0).setCellValue(pato.getId());
            row.createCell(1).setCellValue(pato.getNome());
            row.createCell(2).setCellValue(pato.getStatus());
            row.createCell(3).setCellValue(pato.getValor());
        }

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        workbook.write(outputStream);
        workbook.close();

        return new ByteArrayInputStream(outputStream.toByteArray());
    }
}