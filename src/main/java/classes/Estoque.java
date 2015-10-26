package classes;

import java.time.LocalDate;

public class Estoque {

    private String codigo;
    private int quantidade;
    private LocalDate data;

    public Estoque(String codigo, int quantidade) {
        this.codigo = codigo;
        this.quantidade = quantidade;
        data = LocalDate.now();
    }

    public Estoque(String codigo, LocalDate dataDeEntrada, int quantidade) {
        this.codigo = codigo;
        this.quantidade = quantidade;
        data = dataDeEntrada;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
