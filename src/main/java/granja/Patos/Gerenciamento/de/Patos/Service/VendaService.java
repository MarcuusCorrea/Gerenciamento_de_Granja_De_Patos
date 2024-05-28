package granja.Patos.Gerenciamento.de.Patos.Service;

import granja.Patos.Gerenciamento.de.Patos.Model.Cliente;
import granja.Patos.Gerenciamento.de.Patos.Model.Pato;
import granja.Patos.Gerenciamento.de.Patos.Model.Venda;
import granja.Patos.Gerenciamento.de.Patos.Repository.ClienteRepository;
import granja.Patos.Gerenciamento.de.Patos.Repository.PatoRepository;
import granja.Patos.Gerenciamento.de.Patos.Repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private PatoRepository patoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public Venda registrarVenda(List<Long> idsPatos, Long idCliente) {
        System.out.println("Registrando uma nova venda...");
        try {
            Venda venda = new Venda();
            Cliente cliente = clienteRepository.findById(idCliente).orElseThrow();
            List<Pato> patos = patoRepository.findAllById(idsPatos);
            double valorTotal = patos.stream().mapToDouble(Pato::getValor).sum();

            if (cliente.getElegivelDesconto()) {
                valorTotal *= 0.8;
            }

            venda.setPatos(patos);
            venda.setCliente(cliente);
            venda.setValorTotal(valorTotal);
            venda.setDataVenda(new Date());

            return vendaRepository.save(venda);
        } catch (Exception e) {
            System.err.println("Erro ao registrar a venda: " + e.getMessage());
            e.printStackTrace(); // Imprime o stack trace da exceção
            throw e; // Relança a exceção para que o Spring possa tratá-la adequadamente
        }
    }

    public List<Venda> listarVendas() {
        return vendaRepository.findAll();
    }

    public List<Pato> listarPatosVendidos() {
        return patoRepository.findAll().stream()
                .filter(pato -> "Vendido".equals(pato.getStatus()))
                .collect(Collectors.toList());
    }
}