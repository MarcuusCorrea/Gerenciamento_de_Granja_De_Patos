package granja.Patos.Gerenciamento.de.Patos.Service;

import granja.Patos.Gerenciamento.de.Patos.Model.Pato;
import granja.Patos.Gerenciamento.de.Patos.Repository.PatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatoService {

    @Autowired
    private PatoRepository patoRepository;

    public Pato cadastrarPato(Pato pato) {
        if (pato.getMae() != null && pato.getMae().getId() != null) {
            Pato mae = patoRepository.findById(pato.getMae().getId()).orElse(null);
            pato.setMae(mae);
        }
        return patoRepository.save(pato);
    }
    public List<Pato> listarPatos() {
        return patoRepository.findAll();
    }
    public Pato obterPatoPorId(Long id) {
        return patoRepository.findById(id).orElse(null);

    }
    public boolean deletarPato(Long id) {
        if (patoRepository.existsById(id)) {
            patoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}