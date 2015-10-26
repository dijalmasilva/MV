package classes;

public class Produto {

    private double valorEntrada;

    private double valorSaida;

    private String codigo;

    private String nome;

    private int desconto;

    public Produto(String codigo, String nome, double valorEntrada, int desconto, double valorSaida) {
        this.codigo = codigo;
        this.nome = nome;
        this.valorEntrada = valorEntrada;
        this.desconto = desconto;
        this.valorSaida = valorSaida;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getValorEntrada() {
        return valorEntrada;
    }

    public void setValorEntrada(double valorEntrada) {
        this.valorEntrada = valorEntrada;
    }

    public double getValorSaida() {
        return valorSaida;
    }

    public void setValorSaida(double valorSaida) {
        this.valorSaida = valorSaida;
    }

    public int getDesconto() {
        return desconto;
    }

    public void setDesconto(int desconto) {
        this.desconto = desconto;
    }
}