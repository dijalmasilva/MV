package DAO;

import classes.GeradorDePDF;
import classes.ItemDeVenda;
import classes.Parcelas;
import classes.Venda;
import com.itextpdf.text.DocumentException;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class VendaDAO {

    private Connection con;
    private final String url;
    private final String user;
    private final String password;

    public VendaDAO() {
        url = "jdbc:postgresql://localhost:5432/mv";
        user = "postgres";
        password = "manoeldj20";
    }

    public void connect() {
        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao se conectar com o banco.");
        }
    }

    public void disconnect() {
        try {
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao desconectar do banco.");
        }
    }

    public boolean addPrazo(Venda v) throws DocumentException, FileNotFoundException, IOException {
        connect();
        boolean result = false;
        String sql = "insert into venda (tipopagamento, total, cpfcliente, datadavenda, qtdeParcelas) values (?,?,?,?,?)";
        String data = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yy"));
        String[] n = data.split("/");
        data = n[0] + "." + n[1] + "." + n[2];
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, v.getFormaDePagamento());
            stmt.setDouble(2, v.getTotal());
            stmt.setString(3, v.getCpfCliente());
            stmt.setDate(4, Date.valueOf(v.getData()));
            stmt.setInt(5, v.getQtdeParcelas());
            stmt.executeUpdate();
            stmt.close();
            result = true;
            v.setCodigo(retornaProximoID() - 1);
            GeradorDePDF g = new GeradorDePDF();
            g.gerarVendaPrazo(v, v.getCpfCliente());
            Desktop d = Desktop.getDesktop();
            d.open(new File("/DocumentosPDF/" + data + "/Venda" + v.getCodigo() + "(APrazo)" + new ClienteDAO().getNome(v.getCpfCliente()) + ".pdf"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao guardar venda no banco de dados.");
        } finally {
            disconnect();
        }

        return result;
    }

    public boolean addVista(Venda v, boolean darDesconto, double descontoAdicional) throws DocumentException, FileNotFoundException, IOException {
        connect();
        boolean result = false;
        String sql = "insert into venda (tipopagamento, total, datadavenda) values (?,?,?)";
        String data = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yy"));
        String[] n = data.split("/");
        data = n[0] + "." + n[1] + "." + n[2];
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, v.getFormaDePagamento());
            if (darDesconto) {
                stmt.setDouble(2, v.getTotalComDesconto() - descontoAdicional);
            } else {
                stmt.setDouble(2, v.getTotal());
            }
            stmt.setDate(3, Date.valueOf(v.getData()));
            stmt.executeUpdate();
            stmt.close();
            result = true;
            v.setCodigo(retornaProximoID() - 1);
            GeradorDePDF g = new GeradorDePDF();
            if (darDesconto) {
                g.gerarVendaVista(v, descontoAdicional);
            } else {
                g.gerarVendaVistaSemDesconto(v);
            }
            Desktop d = Desktop.getDesktop();
            d.open(new File("/DocumentosPDF/" + data + "/Venda" + v.getCodigo() + "(AVista).pdf"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao guardar venda no banco de dados.");
            ex.printStackTrace();
        } finally {
            disconnect();
        }

        return result;
    }

    public boolean addVistaOutro(Venda v) throws DocumentException, FileNotFoundException, IOException {
        connect();
        boolean result = false;
        String sql = "insert into venda (tipopagamento, total, datadavenda) values (?,?,?)";
        String data = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yy"));
        String[] n = data.split("/");
        data = n[0] + "." + n[1] + "." + n[2];
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, v.getFormaDePagamento());
            stmt.setDouble(2, v.getTotal());
            stmt.setDate(3, Date.valueOf(v.getData()));
            stmt.executeUpdate();
            stmt.close();
            result = true;
            GeradorDePDF g = new GeradorDePDF();
            v.setCodigo(retornaProximoID() - 1);
            g.gerarVendaVistaSemDesconto(v);
            Desktop d = Desktop.getDesktop();
            d.open(new File("/DocumentosPDF/" + data + "/Venda" + v.getCodigo() + "(AVista).pdf"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao guardar venda no banco de dados.");
            ex.printStackTrace();
        } finally {
            disconnect();
        }

        return result;
    }

    public ArrayList<Venda> getPrazo() {
        ArrayList<Venda> vendas = new ArrayList();

        connect();
        String sql = "select * from venda where tipopagamento = 'Prazo' order by id";
        try {
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery(sql);

            while (rs.next()) {
                String cpf = rs.getString("cpfcliente");
                double total = rs.getDouble("total");
                LocalDate datadavenda = rs.getDate("datadavenda").toLocalDate();
                int qtdeParcelas = rs.getInt("qtdeParcelas");
                int codigo = rs.getInt("id");
                ArrayList<ItemDeVenda> itens = new ItemDeVendaDAO().getByIdVenda(codigo);
                ArrayList<Parcelas> parcelas = new ParcelasDAO().getParcelasNaoPagasPorIDDeVenda(codigo);
                if (!parcelas.isEmpty()) {
                    Venda v = new Venda(total, cpf, datadavenda, qtdeParcelas, codigo, parcelas, itens, "Prazo");
                    vendas.add(v);
                }
            }

            rs.close();
            stat.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar vendas a Prazo no banco de dados.");
            ex.printStackTrace();
        } finally {
            disconnect();
        }
        return vendas;
    }

    public int retornaProximoID() {
        int i = 0;

        connect();
        try {
            Statement stat = con.createStatement();
            String sql = "select max(id) from venda";
            ResultSet rs = stat.executeQuery(sql);

            if (rs.next()) {
                i = rs.getInt("max");
            }

            rs.close();
            stat.close();
        } catch (SQLException localSQLException) {
        } finally {
            disconnect();
        }

        i++;
        return i;
    }
}