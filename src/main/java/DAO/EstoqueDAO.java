package DAO;

import classes.Estoque;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class EstoqueDAO {

    private Connection con;
    private final String user;
    private final String url;
    private final String senha;

    public EstoqueDAO() {
        url = "jdbc:postgresql://localhost:5432/mv";
        user = "postgres";
        senha = "manoeldj20";
    }

    public void connect() {
        try {
            con = DriverManager.getConnection(url, user, senha);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar-se com o banco.");
        }
    }

    public void disconnect() {
        try {
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao desconectar-se do banco.");
        }
    }

    public void add(Estoque e) {
        connect();
        String sql = "insert into estoque (idproduto, datadeentrada, quantidade) values (?,?,?)";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, e.getCodigo());
            stmt.setDate(2, Date.valueOf(e.getData()));
            stmt.setInt(3, e.getQuantidade());

            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Produto não guardado no estoque.");
            ex.printStackTrace();
        }
    }

    public void edit(Estoque e) {
        connect();
        e.setData(LocalDate.now());
        String sql = "update estoque set datadeentrada = '" + Date.valueOf(e.getData()) + "', quantidade=" + e.getQuantidade() + " where idproduto='" + e.getCodigo() + "'";
        try {
            Statement stat = con.createStatement();
            stat.executeUpdate(sql);
            stat.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao editar no estoque.");
            ex.printStackTrace();
        } finally {
            disconnect();
        }
    }

    public void editQuantidade(Estoque e) {
        connect();

        String sql = "update estoque set quantidade=" + e.getQuantidade() + " where idproduto='" + e.getCodigo() + "'";
        try {
            Statement stat = con.createStatement();
            stat.executeUpdate(sql);
            stat.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao editar no estoque.");
            ex.printStackTrace();
        }
    }

    public Estoque retornaEstoque(String id) {
        connect();
        Estoque e = null;
        String sql = "select * from estoque where idproduto = " + id + "";

        try {
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery(sql);

            if (rs.next()) {
                LocalDate dataDeEntrada = rs.getDate("datadeentrada").toLocalDate();
                int quantidade = rs.getInt("quantidade");

                e = new Estoque(id, dataDeEntrada, quantidade);
            }
            rs.close();
            stat.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao recuperar produto no estoque.");
            ex.printStackTrace();
        } finally {
            disconnect();
        }

        return e;
    }

    public ArrayList<Estoque> get() {
        connect();

        ArrayList<Estoque> estoque = new ArrayList();

        String sql = "select * from estoque";
        try {
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery(sql);

            while (rs.next()) {
                String idProduto = rs.getString("idproduto");
                LocalDate dataDeEntrada = rs.getDate("datadeentrada").toLocalDate();
                int quantidade = rs.getInt("quantidade");

                Estoque e = new Estoque(idProduto, dataDeEntrada, quantidade);
                estoque.add(e);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar carregar estoque!");
        } finally {
            disconnect();
        }

        return estoque;
    }
}