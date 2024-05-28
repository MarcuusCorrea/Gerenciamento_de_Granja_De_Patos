package granja.Patos.Gerenciamento.de.Patos.Repository;

import granja.Patos.Gerenciamento.de.Patos.Model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}