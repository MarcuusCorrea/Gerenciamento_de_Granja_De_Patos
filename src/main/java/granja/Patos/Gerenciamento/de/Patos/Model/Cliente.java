package granja.Patos.Gerenciamento.de.Patos.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Boolean elegivelDesconto;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean getElegivelDesconto() {
        return elegivelDesconto;
    }

    public void setElegivelDesconto(boolean elegivelDesconto) {
        this.elegivelDesconto = elegivelDesconto;
    }
}