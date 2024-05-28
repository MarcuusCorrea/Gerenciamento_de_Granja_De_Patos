package granja.Patos.Gerenciamento.de.Patos.Repository;

import granja.Patos.Gerenciamento.de.Patos.Model.Pato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatoRepository extends JpaRepository<Pato, Long> {

    @Query("SELECT p FROM Pato p LEFT JOIN FETCH p.filhos WHERE p.id = :id")
    Optional<Pato> findByIdWithRelations(Long id);
}