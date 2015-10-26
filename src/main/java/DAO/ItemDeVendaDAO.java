package DAO;

import classes.ItemDeVenda;
import classes.Produto;
import classes.Venda;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ItemDeVendaDAO {

    private Connection con;
    private final String user;
    private final String url;
    private final String password;

    public ItemDeVendaDAO() {
        user = "postgres";
        url = "jdbc:postgresql://localhost:5432/mv";
        password = "manoeldj20";
    }

    public void connect() {
        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar-se com o banco.");
        }
    }

    public void disconnect() {
        try {
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao se desconectar do banco.");
        }
    }

    public void add(ItemDeVenda i, Venda v) {
        connect();
        String sql = "insert into itemdevenda (quantidade, subtotal, codigoproduto, idvenda) values (?,?,?,?)";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, i.getQtde());
            stmt.setDouble(2, i.getSubTotal());
            stmt.setString(3, new ProdutoDAO().recuperaCodigo(i.getP()));
            stmt.setInt(4, v.getCodigo());

            stmt.executeUpdate();

            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao guardar item de venda no banco de dados");
        } finally {
            disconnect();
        }
    }

    public ArrayList<ItemDeVenda> getByIdVenda(int codigoVenda) {
        ArrayList<ItemDeVenda> itens = new ArrayList();

        connect();
        try {
            Statement stat = con.createStatement();
            String sql = "select * from itemdevenda where idvenda = '" + codigoVenda + "'";
            ResultSet rs = stat.executeQuery(sql);

            while (rs.next()) {
                int quantidade = rs.getInt("quantidade");
                double subtotal = rs.getDouble("subtotal");
                Produto p = new ProdutoDAO().retornaProduto(rs.getString("codigoproduto"));

                itens.add(new ItemDeVenda(p, quantidade, subtotal));
            }

            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao recuperar itens de venda no banco de dados.");
        } finally {
            disconnect();
        }

        return itens;
    }
}