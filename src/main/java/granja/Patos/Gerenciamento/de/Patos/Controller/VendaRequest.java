package granja.Patos.Gerenciamento.de.Patos.Controller;

import java.util.List;

public class VendaRequest {
    private List<Long> idsPatos;
    private Long idCliente;

    // Getters and Setters
    public List<Long> getIdsPatos() {
        return idsPatos;
    }

    public void setIdsPatos(List<Long> idsPatos) {
        this.idsPatos = idsPatos;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }
}