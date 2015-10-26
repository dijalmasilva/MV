package classes;

import DAO.ClienteDAO;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GeradorDePDF {

    private final Document documento;
    DecimalFormat df = new DecimalFormat("#,###.00");

    public GeradorDePDF() {
        documento = new Document();
    }

    public void gerarVendaVista(Venda v, double descontoAdicional) throws DocumentException, FileNotFoundException {
        String data = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yy"));
        String[] n = data.split("/");
        data = n[0] + "." + n[1] + "." + n[2];
        String cam = "/DocumentosPDF/";
        String caminho = "/DocumentosPDF/" + data + "";
        if (!new File(cam).exists()) {
            new File(cam).mkdir();
        }
        if (!new File(caminho).exists()) {
            new File(caminho).mkdir();
        }

        PdfWriter.getInstance(documento, new FileOutputStream("/DocumentosPDF/" + data + "/Venda" + v.getCodigo() + "(AVista).pdf"));
        documento.open();
        documento.add(new Paragraph("                                                                           MV.com \n \n \n \n \n"));
        documento.add(new Paragraph("Venda " + v.getCodigo() + " – " + LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yy")) + "                                                                                   TOTAL: " + df.format(v.getTotalComDesconto() - descontoAdicional) + " R$ \n \n" + "Forma de pagamento – " + v
                .getFormaDePagamento() + "\n\n\n"));
        documento.add(new Paragraph("Itens comprados \n \n"));
        int cont = 1;
        for (ItemDeVenda i : v.getItens()) {
            documento.add(new Paragraph("Produto " + cont++ + " – " + i.getP().getNome() + "                                      \n Valor Unitário: " + df.format(i.getP().getValorSaida()) + "\n" + "Quantidade: " + i
                    .getQtde() + "                         Valor: " + df.format(i.getSubTotal()) + " R$                      Com desconto: " + df.format(i.calcularSubTotalComDesconto()) + " R$ \n \n"));
        }
        documento.close();
    }

    public void gerarVendaPrazo(Venda v, String cpf) throws DocumentException, FileNotFoundException {
        String data = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yy"));
        String[] n = data.split("/");
        data = n[0] + "." + n[1] + "." + n[2];
        String cam = "/DocumentosPDF/";
        String caminho = "/DocumentosPDF/" + data + "";
        if (!new File(cam).exists()) {
            new File(cam).mkdir();
        }
        if (!new File(caminho).exists()) {
            new File(caminho).mkdir();
        }
        String nome = new ClienteDAO().getNome(cpf);
        PdfWriter.getInstance(documento, new FileOutputStream("/DocumentosPDF/" + data + "/Venda" + v.getCodigo() + "(APrazo)" + nome + ".pdf"));
        documento.open();
        documento.add(new Paragraph("                                                                           MV.com \n \n \n \n \n"));
        documento.add(new Paragraph("Venda " + v.getCodigo() + " – " + LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yy")) + "                                                                                   TOTAL: " + df.format(v.getTotal()) + " R$ \n \n" + "Forma de pagamento – " + v
                .getFormaDePagamento() + "\n\n\n"));
        documento.add(new Paragraph("Cliente: " + nome + "\n" + "CPF: " + cpf + " \n \n "));

        documento.add(new Paragraph("Itens comprados \n \n"));
        int cont = 1;
        for (ItemDeVenda i : v.getItens()) {
            documento.add(new Paragraph("Produto " + cont++ + " – " + i.getP().getNome() + "                                       \n Valor Unitário: " + df.format(i.getP().getValorSaida()) + "\n" + "Quantidade: " + i
                    .getQtde() + "                                   Valor: " + df.format(i.getSubTotal()) + " R$ \n \n"));
        }

        documento.newPage();
        double valor = v.getTotal() / v.getQtdeParcelas();
        LocalDate date = LocalDate.now();
        PdfPTable pTable = new PdfPTable(2);
        pTable.setLockedWidth(true);
        pTable.setTotalWidth(550.0F);
        pTable.setTotalWidth(new float[]{400.0F, 150.0F});
        pTable.addCell(new Paragraph(4.0F, "\nMV.com – Eletrônico, Informática e Variedades\n\nCódigo de venda: " + v
                .getCodigo() + "                                      Data: " + date.format(DateTimeFormatter.ofPattern("dd/MM/yy")) + "\n\n" + "Cliente: " + nome + "              \n\n" + "CPF: " + cpf + "\n\n" + "Total: " + df
                .format(v.getTotal()) + " R$                                                         Parcelas: " + v.getQtdeParcelas() + "\n\n"));
        pTable.addCell("");
        for (int i = 1; i <= v.getQtdeParcelas(); i++) {
            pTable.addCell(new Paragraph(4.0F, "\nCód. Venda: " + v.getCodigo() + "\n\n" + "CPF: " + cpf + "\n\n" + "Nº Parcela: " + i + "                                          Vencimento: " + date
                    .plusMonths(i).format(DateTimeFormatter.ofPattern("dd/MM/yy")) + "\n\n\n" + "Valor: " + df
                    .format(valor) + " R$"));
            pTable.addCell(new Paragraph(4.0F, "\n      Cód. Venda: " + v.getCodigo() + "\n\n" + "     CPF: " + cpf + "\n\n" + "     Nº Parcela: " + i + "\n\n" + "     Vencimento: " + date
                    .plusMonths(i).format(DateTimeFormatter.ofPattern("dd/MM/yy")) + "\n\n" + "     Valor: " + df
                    .format(valor) + "\n\n"));
        }
        documento.add(pTable);
        documento.close();
    }

    public void gerarVendaVistaSemDesconto(Venda v) {
        String data = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yy"));
        String[] n = data.split("/");
        data = n[0] + "." + n[1] + "." + n[2];
        String cam = "/DocumentosPDF/";
        String caminho = "/DocumentosPDF/" + data + "";
        if (!new File(cam).exists()) {
            new File(cam).mkdir();
        }
        if (!new File(caminho).exists()) {
            new File(caminho).mkdir();
        }
        try {
            PdfWriter.getInstance(documento, new FileOutputStream("/DocumentosPDF/" + data + "/Venda" + v.getCodigo() + "(AVista).pdf"));
        } catch (FileNotFoundException | DocumentException ex) {
            Logger.getLogger(GeradorDePDF.class.getName()).log(Level.SEVERE, null, ex);
        }
        documento.open();
        try {
            documento.add(new Paragraph("                                                                           MV.com \n \n \n \n \n"));
            documento.add(new Paragraph("Venda " + v.getCodigo() + " – " + LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yy")) + "                                                                                   TOTAL: " + v.getTotal() + " R$ \n \n" + "Forma de pagamento – " + v
                    .getFormaDePagamento() + "\n\n\n"));
            documento.add(new Paragraph("Itens comprados \n \n \n"));
            int cont = 1;
            for (ItemDeVenda i : v.getItens()) {
                documento.add(new Paragraph("Produto " + cont++ + " – " + i.getP().getNome() + "                                      \n Valor Unitário: " + i.getP().getValorSaida() + "\n" + "Quantidade: " + i
                        .getQtde() + "                         Valor: " + i.getSubTotal() + " R$ \n \n"));
            }
        } catch (DocumentException ex) {
            int cont;
            Logger.getLogger(GeradorDePDF.class.getName()).log(Level.SEVERE, null, ex);
        }
        documento.close();
    }
}
