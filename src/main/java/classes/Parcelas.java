package classes;

import java.time.LocalDate;
import java.time.Period;

public class Parcelas {

    private int idVenda;
    private double valor;
    private LocalDate dataDeVencimento;
    private boolean isPago;

    public Parcelas(int idVenda, double valor, LocalDate dataDeVencimento, boolean isPago) {
        this.idVenda = idVenda;
        this.valor = valor;
        this.dataDeVencimento = dataDeVencimento;
        this.isPago = isPago;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDate getDataDeVencimento() {
        return dataDeVencimento;
    }

    public void setDataDeVencimento(LocalDate dataDeVencimento) {
        this.dataDeVencimento = dataDeVencimento;
    }

    public boolean verificarAtraso() {
        LocalDate dataDeHoje = LocalDate.now();

        return dataDeHoje.isAfter(dataDeVencimento);
    }

    public boolean seVenceHoje() {
        LocalDate dataDeHoje = LocalDate.now();

        return dataDeHoje.isEqual(dataDeVencimento);
    }

    public Period CompararVencimento() {
        LocalDate dataDeHoje = LocalDate.now();

        return dataDeHoje.until(dataDeVencimento);
    }

    public boolean getIsPago() {
        return isPago;
    }

    public void setIsPago(boolean isPago) {
        this.isPago = isPago;
    }
}
