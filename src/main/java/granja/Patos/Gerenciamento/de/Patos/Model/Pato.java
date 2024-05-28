package granja.Patos.Gerenciamento.de.Patos.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Pato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String status;
    private Double valor;

    @ManyToOne
    @JoinColumn(name = "mae_id")
    private Pato mae;

    @OneToMany(mappedBy = "mae", cascade = CascadeType.ALL)
    private List<Pato> filhos = new ArrayList<>();


    public double getValor() {
        return valor;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Pato getMae() {
        return mae;
    }

    public void setMae(Pato mae) {
        this.mae = mae;
    }

    public List<Pato> getFilhos() {
        return filhos;
    }
    public void setFilhos(List<Pato> filhos) {
        this.filhos = filhos;
    }

    public void addFilho(Pato filho) {
        filho.setMae(this);
        this.filhos.add(filho);
    }

    public void removeFilho(Pato filho) {
        filho.setMae(null);
        this.filhos.remove(filho);
    }
}
