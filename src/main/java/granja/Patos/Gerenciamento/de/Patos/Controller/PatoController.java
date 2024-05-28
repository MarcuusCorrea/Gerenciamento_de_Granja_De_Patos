package granja.Patos.Gerenciamento.de.Patos.Controller;

import granja.Patos.Gerenciamento.de.Patos.Model.Pato;
import granja.Patos.Gerenciamento.de.Patos.Model.Venda;
import granja.Patos.Gerenciamento.de.Patos.Service.PatoService;
import granja.Patos.Gerenciamento.de.Patos.Service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patos")
public class PatoController {

    @Autowired
    private PatoService patoService;

    @Autowired
    private VendaService vendaService;

    @PostMapping
    public ResponseEntity<Pato> cadastrarPato(@RequestBody Pato pato) {
        Pato novoPato = patoService.cadastrarPato(pato);
        return new ResponseEntity<>(novoPato, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Pato> listarPatos() {
        return patoService.listarPatos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pato> obterPatoPorId(@PathVariable Long id) {
        Pato pato = patoService.obterPatoPorId(id);
        if (pato != null) {
            return ResponseEntity.ok(pato);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}/vendido")
    public ResponseEntity<String> marcarPatoComoVendido(@PathVariable Long id) {
        Pato pato = patoService.obterPatoPorId(id);
        if (pato != null) {
            pato.setStatus("Vendido");
            patoService.cadastrarPato(pato);
            return ResponseEntity.ok("Pato marcado como vendido com sucesso.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPato(@PathVariable Long id) {
        boolean deletado = patoService.deletarPato(id);
        if (deletado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
        @GetMapping("/vendidos")
        public List<Venda> listarVendas() {
            return vendaService.listarVendas();
        }
    }
