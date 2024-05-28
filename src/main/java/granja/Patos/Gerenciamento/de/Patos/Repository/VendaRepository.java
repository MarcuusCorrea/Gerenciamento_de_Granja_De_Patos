package granja.Patos.Gerenciamento.de.Patos.Repository;

import granja.Patos.Gerenciamento.de.Patos.Model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {

}