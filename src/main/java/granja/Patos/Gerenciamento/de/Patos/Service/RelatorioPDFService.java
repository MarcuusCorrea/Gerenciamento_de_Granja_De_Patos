package granja.Patos.Gerenciamento.de.Patos.Service;

import granja.Patos.Gerenciamento.de.Patos.Model.Pato;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RelatorioPDFService {

    public ByteArrayInputStream gerarRelatorioDePatos(List<Pato> patos) throws JRException {
        try {
            InputStream templateStream = getClass().getResourceAsStream("/templates/relatorio_patos.jrxml");

            if (templateStream == null) {
                throw new JRRuntimeException("Arquivo de modelo do relatório não encontrado.");
            }

            JasperReport jasperReport = JasperCompileManager.compileReport(templateStream);

            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(patos);

            Map<String, Object> parameters = new HashMap<>();

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);

            return new ByteArrayInputStream(outputStream.toByteArray());
        } catch (JRException e) {
            throw new JRException("Erro ao gerar relatório em PDF: " + e.getMessage(), e);
        }
    }
}