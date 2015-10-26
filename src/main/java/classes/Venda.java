package classes;

import java.time.LocalDate;
import java.util.ArrayList;

public class Venda {

    private ArrayList<ItemDeVenda> itens;
    private ArrayList<Parcelas> parcelas;
    private double total;
    private String formaDePagamento;
    private String cpfCliente;
    private LocalDate data;
    private int qtdeParcelas;
    private int codigo;

    public Venda() {
        itens = new ArrayList();
        total = 0.0D;
        formaDePagamento = "";
        cpfCliente = "";
        data = null;
        qtdeParcelas = 0;
    }

    public Venda(double total, String cpfCliente, LocalDate data, int qtdeParcelas, int codigo) {
        itens = new ArrayList();
        this.total = total;
        this.cpfCliente = cpfCliente;
        this.data = data;
        this.qtdeParcelas = qtdeParcelas;
        formaDePagamento = "";
        this.codigo = codigo;
    }

    public Venda(double total, String cpfCliente, LocalDate data, int qtdeParcelas, int codigo, ArrayList<Parcelas> parcelas, ArrayList<ItemDeVenda> itens, String formaDePagamento) {
        this.itens = itens;
        this.total = total;
        this.cpfCliente = cpfCliente;
        this.data = data;
        this.qtdeParcelas = qtdeParcelas;
        this.formaDePagamento = formaDePagamento;
        this.codigo = codigo;
        this.parcelas = parcelas;
    }

    public void addItens(ItemDeVenda item) {
        itens.add(item);
        total += item.getSubTotal();
    }

    public void removerItens(ItemDeVenda item) {
        itens.remove(item);
        total -= item.getSubTotal();
    }

    public ArrayList<ItemDeVenda> getItens() {
        return itens;
    }

    public void setItens(ArrayList<ItemDeVenda> itens) {
        this.itens = itens;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTotalComDesconto() {
        double soma = 0.0D;
        for (ItemDeVenda item : itens) {
            soma += item.calcularSubTotalComDesconto();
        }

        return soma;
    }

    public void mudarTotal() {
        total = 0.0D;
        for (ItemDeVenda item : itens) {
            total += item.getSubTotal();
        }
    }

    public void setTotalComDesconto() {
        total = getTotalComDesconto();
    }

    public String getFormaDePagamento() {
        return formaDePagamento;
    }

    public void setFormaDePagamento(String formaDePagamento) {
        this.formaDePagamento = formaDePagamento;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void mudarDataParaAgora() {
        data = LocalDate.now();
    }

    public int getQtdeParcelas() {
        return qtdeParcelas;
    }

    public void setQtdeParcelas(int qtdeParcelas) {
        this.qtdeParcelas = qtdeParcelas;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public ArrayList<Parcelas> getParcelas() {
        return parcelas;
    }

    public void setParcelas(ArrayList<Parcelas> parcelas) {
        this.parcelas = parcelas;
    }
}