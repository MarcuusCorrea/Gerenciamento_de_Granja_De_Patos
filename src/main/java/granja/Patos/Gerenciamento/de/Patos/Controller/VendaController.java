package granja.Patos.Gerenciamento.de.Patos.Controller;

import granja.Patos.Gerenciamento.de.Patos.Model.Pato;
import granja.Patos.Gerenciamento.de.Patos.Model.Venda;
import granja.Patos.Gerenciamento.de.Patos.Service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @PostMapping
    public ResponseEntity<Venda> registrarVenda(@RequestBody List<Long> idsPatos,
                                                @RequestParam Long idCliente) {
        System.out.println("Recebida requisição para registrar uma nova venda...");
        System.out.println("IDs dos patos: " + idsPatos);
        System.out.println("ID do cliente: " + idCliente);

        try {
            Venda novaVenda = vendaService.registrarVenda(idsPatos, idCliente);
            return new ResponseEntity<>(novaVenda, HttpStatus.CREATED);
        } catch (Exception e) {
            System.err.println("Erro ao registrar a venda: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }

    @GetMapping
    public List<Venda> listarVendas() {
        System.out.println("Recebida requisição para listar todas as vendas...");
        return vendaService.listarVendas();
    }

    @GetMapping("/patos-vendidos")
    public List<Pato> listarPatosVendidos() {
        System.out.println("Recebida requisição para listar todos os patos vendidos...");
        return vendaService.listarPatosVendidos();
    }
}