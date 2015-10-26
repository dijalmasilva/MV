package DAO;

import classes.Produto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ProdutoDAO {

    private Connection con;
    private final String user;
    private final String url;
    private final String senha;

    public ProdutoDAO() {
        url = "jdbc:postgresql://localhost:5432/mv";
        user = "postgres";
        senha = "manoeldj20";
    }

    public void connect() {
        try {
            con = DriverManager.getConnection(url, user, senha);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco.");
        }
    }

    public void disconnect() {
        try {
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao se desconectar com o banco.");
        }
    }

    public boolean add(Produto p) {
        connect();
        String sql = "Insert into produto(codigo, nome, valorentrada, valorsaida, desconto) values (?,?,?,?,?)";
        boolean result = false;
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, p.getCodigo());
            stmt.setString(2, p.getNome());
            stmt.setDouble(3, p.getValorEntrada());
            stmt.setDouble(4, p.getValorSaida());
            stmt.setInt(5, p.getDesconto());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
            stmt.close();
            result = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar produto!");
        } finally {
            disconnect();
        }
        return result;
    }

    public void remove(Produto p) {
        connect();
        String sql = "delete from produto where codigo ilike '" + p.getCodigo() + "'";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            disconnect();
        }
    }

    public String recuperaCodigo(Produto p) {
        connect();
        String sql = "select codigo from produto where nome ilike ?";
        String codigo = "";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, p.getNome());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                codigo = rs.getString("codigo");
            }
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            disconnect();
        }

        return codigo;
    }

    public String recuperaNome(String codigo) {
        connect();
        String sql = "select nome from produto where codigo ilike ?";
        String nome = "";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, codigo);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                nome = rs.getString("nome");
            }
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            disconnect();
        }

        return nome;
    }

    public ArrayList<Produto> get() {
        ArrayList<Produto> produtos = new ArrayList();
        connect();
        String sql = "select * from produto order by nome";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String nomeP = rs.getString("nome");
                String codigo = rs.getString("codigo");
                double valorEntrada = rs.getDouble("valorentrada");
                int desconto = rs.getInt("desconto");
                double valorSaida = rs.getDouble("valorsaida");
                Produto p = new Produto(codigo, nomeP, valorEntrada, desconto, valorSaida);
                produtos.add(p);
            }

            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            disconnect();
        }

        return produtos;
    }

    public ArrayList<Produto> getByNames(String name) {
        ArrayList<Produto> produtos = new ArrayList();
        connect();
        String sql = "select * from produto where nome ilike '%" + name + "%' order by nome";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String nome = rs.getString("nome");
                String codigo = rs.getString("codigo");
                double valorEntrada = rs.getDouble("valorentrada");
                int desconto = rs.getInt("desconto");
                double valorSaida = rs.getDouble("valorsaida");
                Produto p = new Produto(codigo, nome, valorEntrada, desconto, valorSaida);
                produtos.add(p);
            }

            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            disconnect();
        }

        return produtos;
    }

    public ArrayList<Produto> getByCodigo(String codigo) {
        ArrayList<Produto> produtos = new ArrayList();
        connect();
        String sql = "select * from produto where codigo ilike '%" + codigo + "%' order by nome";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String nome = rs.getString("nome");
                String cod = rs.getString("codigo");
                double valorEntrada = rs.getDouble("valorentrada");
                int desconto = rs.getInt("desconto");
                double valorSaida = rs.getDouble("valorsaida");
                Produto p = new Produto(cod, nome, valorEntrada, desconto, valorSaida);
                produtos.add(p);
            }

            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            disconnect();
        }

        return produtos;
    }

    public Produto retornaProduto(String codigo) {
        Produto p = null;

        connect();
        try {
            Statement stat = con.createStatement();
            String sql = "select * from produto where codigo = '" + codigo + "'";
            ResultSet rs = stat.executeQuery(sql);
            if (rs.next()) {
                String nome = rs.getString("nome");
                double valorEntrada = rs.getDouble("valorentrada");
                int desconto = rs.getInt("desconto");
                double valorSaida = rs.getDouble("valorsaida");

                p = new Produto(codigo, nome, valorEntrada, desconto, valorSaida);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao recuperar produto no banco de dados.");
        }

        return p;
    }

    public boolean edit(Produto p) {
        boolean result = false;

        String sql = "update produto set nome = '" + p.getNome() + "', valorentrada = " + p.getValorEntrada() + ", valorsaida = " + p.getValorSaida() + ", desconto = " + p.getDesconto() + " where codigo = '" + p.getCodigo() + "'";

        connect();
        try {
            Statement stmt = con.createStatement();
            if (stmt.executeUpdate(sql) > 0) {
                result = true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao editar produto.");
            ex.printStackTrace();
        } finally {
            disconnect();
        }

        return result;
    }
}