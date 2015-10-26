package DAO;

import classes.Parcelas;
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

public class ParcelasDAO {

    private Connection con;
    private final String user;
    private final String url;
    private final String password;

    public ParcelasDAO() {
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

    public void add(Parcelas pa) {
        connect();

        String sql = "insert into parcelas (idvenda, valor, datadevencimento, ispago) values (?,?,?,?)";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, pa.getIdVenda());
            stmt.setDouble(2, pa.getValor());
            stmt.setDate(3, Date.valueOf(pa.getDataDeVencimento()));
            stmt.setBoolean(4, pa.getIsPago());
            stmt.executeUpdate();

            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao guardar parcela no banco de dados.");
        } finally {
            disconnect();
        }
    }

    public ArrayList<Parcelas> get() {
        ArrayList<Parcelas> parcelas = new ArrayList();

        connect();
        try {
            Statement stat = con.createStatement();
            String sql = "select * from parcelas";
            ResultSet rs = stat.executeQuery(sql);

            while (rs.next()) {
                int idVenda = rs.getInt("idvenda");
                double valor = rs.getDouble("valor");
                LocalDate dataDeVencimento = rs.getDate("datadevencimento").toLocalDate();
                boolean isPago = rs.getBoolean("ispago");

                parcelas.add(new Parcelas(idVenda, valor, dataDeVencimento, isPago));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao recuperar parcelas no banco de dados.");
        } finally {
            disconnect();
        }
        return parcelas;
    }

    public ArrayList<Parcelas> getParcelasNaoPagasPorIDDeVenda(int codVenda) {
        ArrayList<Parcelas> parcelas = new ArrayList();

        connect();
        try {
            Statement stat = con.createStatement();
            String sql = "select * from parcelas where idvenda=" + codVenda + " and ispago = false order by datadevencimento";
            ResultSet rs = stat.executeQuery(sql);

            while (rs.next()) {
                int idVenda = rs.getInt("idvenda");
                double valor = rs.getDouble("valor");
                LocalDate dataDeVencimento = rs.getDate("datadevencimento").toLocalDate();
                boolean isPago = rs.getBoolean("ispago");

                parcelas.add(new Parcelas(idVenda, valor, dataDeVencimento, isPago));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao recuperar parcelas no banco de dados.");
        } finally {
            disconnect();
        }
        return parcelas;
    }

    public ArrayList<Parcelas> getParcelasPagasPorIDDeVenda(int codVenda) {
        ArrayList<Parcelas> parcelas = new ArrayList();

        connect();
        try {
            Statement stat = con.createStatement();
            String sql = "select * from parcelas where idvenda=" + codVenda + " and ispago = true";
            ResultSet rs = stat.executeQuery(sql);

            while (rs.next()) {
                int idVenda = rs.getInt("idvenda");
                double valor = rs.getDouble("valor");
                LocalDate dataDeVencimento = rs.getDate("datadevencimento").toLocalDate();
                boolean isPago = rs.getBoolean("ispago");

                parcelas.add(new Parcelas(idVenda, valor, dataDeVencimento, isPago));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao recuperar parcelas no banco de dados.");
        } finally {
            disconnect();
        }
        return parcelas;
    }

    public void removerParcelas(int idVenda) {
        connect();

        String sql = "delete from parcelas where idvenda = " + idVenda + "";
        try {
            Statement stat = con.createStatement();
            stat.executeUpdate(sql);
            stat.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            disconnect();
        }
    }
}