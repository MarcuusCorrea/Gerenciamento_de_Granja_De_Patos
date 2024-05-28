package granja.Patos.Gerenciamento.de.Patos.Controller;

import granja.Patos.Gerenciamento.de.Patos.Model.Pato;
import granja.Patos.Gerenciamento.de.Patos.Service.PatoService;
import granja.Patos.Gerenciamento.de.Patos.Service.RelatorioExcelService;
import granja.Patos.Gerenciamento.de.Patos.Service.RelatorioPDFService;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.repo.InputStreamResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/relatorios")
public class RelatorioController {

    @Autowired
    private RelatorioExcelService relatorioExcelService;

    @Autowired
    private RelatorioPDFService relatorioPDFService;

    @Autowired
    private PatoService patoService;

    @GetMapping("/excel")
    public ResponseEntity<InputStreamResource> downloadExcel() throws IOException {
        List<Pato> patos = patoService.listarPatos();
        ByteArrayInputStream in = relatorioExcelService.gerarRelatorioDePatos(patos);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=patos.xlsx");
        return ResponseEntity.ok().headers(headers).body(new InputStreamResource());
    }

    @GetMapping("/pdf")
    public ResponseEntity<InputStreamResource> downloadPDF() throws JRException {
        List<Pato> patos = patoService.listarPatos();
        ByteArrayInputStream in = relatorioPDFService.gerarRelatorioDePatos(patos);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=patos.pdf");
        return ResponseEntity.ok().headers(headers).body(new InputStreamResource());
    }
}