package classes;

public class ItemDeVenda {

    private Produto p;

    private double subTotal;

    private int qtde;

    public ItemDeVenda(Produto p, int qtde) {
        this.p = p;
        this.qtde = qtde;
        subTotal = calcularSubTotal();
    }

    public ItemDeVenda(Produto p, int qtde, double subtotal) {
        this.p = p;
        this.qtde = qtde;
        subTotal = subtotal;
    }

    public final double calcularSubTotal() {
        return p.getValorSaida() * qtde;
    }

    public final double calcularSubTotalComDesconto() {
        double d = p.getDesconto();
        double v = p.getValorSaida();
        double desconto = d / 100.0D * v;
        return (v - desconto) * qtde;
    }

    public Produto getP() {
        return p;
    }

    public void setP(Produto p) {
        this.p = p;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotalComDesconto() {
        subTotal = calcularSubTotalComDesconto();
    }

    public void setSubTotal() {
        subTotal = calcularSubTotal();
    }

    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }
}