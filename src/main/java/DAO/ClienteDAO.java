package DAO;

import classes.Cliente;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ClienteDAO {

    private Connection con;
    private final String user;
    private final String url;
    private final String password;

    public ClienteDAO() {
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

    public boolean add(Cliente c) {
        connect();
        boolean result = false;
        String sql = "insert into cliente (cpf, nome, cidade, rua, numero, bairro, limite, telefone, email, datadecadastro, complemento, telefone2, estado) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, c.getCpf());
            stmt.setString(2, c.getNome());
            stmt.setString(3, c.getCidade());
            stmt.setString(4, c.getRua());
            stmt.setInt(5, c.getNumero());
            stmt.setString(6, c.getBairro());
            stmt.setDouble(7, c.getLimite());
            stmt.setString(8, c.getTelefone());
            stmt.setString(9, c.getEmail());
            stmt.setDate(10, Date.valueOf(c.getData()));
            stmt.setString(11, c.getComplemento());
            stmt.setString(12, c.getTelefoneOpcional());
            stmt.setString(13, c.getEstado());
            stmt.executeUpdate();

            stmt.close();
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
            result = true;
        } catch (SQLException ex) {
            if (ex.getSQLState().equals("23505")) {
                JOptionPane.showMessageDialog(null, "CPF já cadastrado.");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar cliente.");
            }
            ex.printStackTrace();
        } finally {
            disconnect();
        }
        return result;
    }

    public void remove(Cliente c) {
        connect();
        try {
            Statement stat = con.createStatement();
            String sql = "delete from cliente where cpf = '" + c.getCpf() + "'";
            stat.executeUpdate(sql);
            stat.close();
            JOptionPane.showMessageDialog(null, "Cliente removido com sucesso.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao remover Cliente.");
            ex.printStackTrace();
        } finally {
            disconnect();
        }
    }

    public void edit(Cliente ant, Cliente novo) {
        connect();

        try {
            String sql = "update cliente set cpf=?, nome=?, rua=?, cidade=?, bairro=?, limite=?,complemento=?, numero=?, telefone=?, email=?, telefone2=?, estado=? where cpf ilike '" + ant.getCpf() + "'";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, novo.getCpf());
            stmt.setString(2, novo.getNome());
            stmt.setString(3, novo.getRua());
            stmt.setString(4, novo.getCidade());
            stmt.setString(5, novo.getBairro());
            stmt.setDouble(6, novo.getLimite());
            stmt.setString(7, novo.getComplemento());
            stmt.setInt(8, novo.getNumero());
            stmt.setString(9, novo.getTelefone());
            stmt.setString(10, novo.getEmail());
            stmt.setString(11, novo.getTelefoneOpcional());
            stmt.setString(12, novo.getEstado());
            stmt.executeUpdate();

            stmt.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar dados do cliente.");
            ex.printStackTrace();
        } finally {
            disconnect();
        }
    }

    public ArrayList<Cliente> get() {
        ArrayList<Cliente> clientes = new ArrayList();

        connect();
        String sql = "select * from cliente order by nome";
        try {
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery(sql);

            while (rs.next()) {
                String cpf = rs.getString("cpf");
                String nome = rs.getString("nome");
                String cidade = rs.getString("cidade");
                String rua = rs.getString("rua");
                int numero = Integer.parseInt(rs.getString("numero"));
                String bairro = rs.getString("bairro");
                double limite = rs.getDouble("limite");
                String telefone = rs.getString("telefone");
                String email = rs.getString("email");
                LocalDate data = rs.getDate("datadecadastro").toLocalDate();
                String complemento = rs.getString("complemento");
                String telefoneopcional = rs.getString("telefone2");
                String estado = rs.getString("estado");

                Cliente c = new Cliente(cpf, nome, cidade, rua, bairro, numero, complemento, estado, limite, telefone, email, telefoneopcional, data);
                clientes.add(c);
            }

            rs.close();
            stat.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            disconnect();
        }

        return clientes;
    }

    public ArrayList<Cliente> getByNames(String name) {
        ArrayList<Cliente> clientes = new ArrayList();

        connect();
        String sql = "select * from cliente where nome ilike '%" + name + "%' order by nome";
        try {
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery(sql);

            while (rs.next()) {
                String cpf = rs.getString("cpf");
                String nome = rs.getString("nome");
                String cidade = rs.getString("cidade");
                String rua = rs.getString("rua");
                int numero = Integer.parseInt(rs.getString("numero"));
                String bairro = rs.getString("bairro");
                double limite = rs.getDouble("limite");
                String telefone = rs.getString("telefone");
                String email = rs.getString("email");
                LocalDate data = rs.getDate("datadecadastro").toLocalDate();
                String complemento = rs.getString("complemento");
                String telefoneopcional = rs.getString("telefone2");
                String estado = rs.getString("estado");

                Cliente c = new Cliente(cpf, nome, cidade, rua, bairro, numero, complemento, estado, limite, telefone, email, telefoneopcional, data);
                clientes.add(c);
            }

            rs.close();
            stat.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            disconnect();
        }

        return clientes;
    }

    public ArrayList<Cliente> getByCPF(String cpf) {
        ArrayList<Cliente> clientes = new ArrayList();

        connect();
        String sql = "select * from cliente where cpf ilike '%" + cpf + "%' order by cpf";
        try {
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery(sql);

            while (rs.next()) {
                String nome = rs.getString("nome");
                String cidade = rs.getString("cidade");
                String rua = rs.getString("rua");
                int numero = Integer.parseInt(rs.getString("numero"));
                String bairro = rs.getString("bairro");
                double limite = rs.getDouble("limite");
                String telefone = rs.getString("telefone");
                String email = rs.getString("email");
                LocalDate data = rs.getDate("datadecadastro").toLocalDate();
                String complemento = rs.getString("complemento");
                String telefoneopcional = rs.getString("telefone2");
                String estado = rs.getString("estado");

                Cliente c = new Cliente(cpf, nome, cidade, rua, bairro, numero, complemento, estado, limite, telefone, email, telefoneopcional, data);
                clientes.add(c);
            }

            rs.close();
            stat.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            disconnect();
        }

        return clientes;
    }

    public String getNome(String cpf) {
        connect();
        String nome = "";
        String sql = "select nome from cliente where cpf = '" + cpf + "'";
        try {
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery(sql);

            if (rs.next()) {
                nome = rs.getString("nome");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao retornar nome do cliente.");
            ex.printStackTrace();
        } finally {
            disconnect();
        }

        return nome;
    }
}