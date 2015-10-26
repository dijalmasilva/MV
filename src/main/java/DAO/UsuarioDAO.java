package DAO;

import classes.Usuario;
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

public class UsuarioDAO {

    private Connection con;
    private final String url;
    private final String user;
    private final String password;

    public UsuarioDAO() {
        url = "jdbc:postgresql://localhost:5432/mv";
        user = "postgres";
        password = "manoeldj20";
    }

    public void connect() {
        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            int i = ex.getErrorCode();
            if (i == 0) {
                CriarBanco c = new CriarBanco();
                connect();
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao tentar se conectar com o banco de dados.");
            }
        }
    }

    public void disconnect() {
        try {
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao tentar se desconectar com o banco de dados.");
        }
    }

    public boolean add(Usuario u) {
        connect();
        boolean result = false;
        String sql = "insert into usuario (cpf, nome, cidade, rua, numero, bairro, telefone, email, datadecadastro,complemento, telefone2, nomedeusuario, senha, administrador, estado, salario) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, u.getCpf());
            stmt.setString(2, u.getNome());
            stmt.setString(3, u.getCidade());
            stmt.setString(4, u.getRua());
            stmt.setInt(5, u.getNumero());
            stmt.setString(6, u.getBairro());
            stmt.setString(7, u.getTelefone());
            stmt.setString(8, u.getEmail());
            stmt.setDate(9, Date.valueOf(u.getData()));
            stmt.setString(10, u.getComplemento());
            stmt.setString(11, u.getTelefoneOpcional());
            stmt.setString(12, u.getUser());
            stmt.setString(13, u.getSenha());
            stmt.setBoolean(14, u.isAdministrador());
            stmt.setString(15, u.getEstado());
            stmt.setDouble(16, u.getSalario());

            stmt.executeUpdate();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso.");
            result = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar usuário.");
        } finally {
            disconnect();
        }

        return result;
    }

    public boolean remove(Usuario u) {
        connect();
        boolean result = false;
        String sql = "delete from usuario where nomedeusuario = '" + u.getUser() + "'";
        try {
            Statement stat = con.createStatement();
            stat.executeUpdate(sql);
            stat.close();
            result = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao remover usuário.");
        } finally {
            disconnect();
        }

        return result;
    }

    public ArrayList<Usuario> get() {
        connect();
        ArrayList<Usuario> usuarios = new ArrayList();
        try {
            Statement stat = con.createStatement();
            String sql = "select * from usuario";
            ResultSet rs = stat.executeQuery(sql);

            while (rs.next()) {
                String nome = rs.getString("nome");
                String cidade = rs.getString("cidade");
                String rua = rs.getString("rua");
                String bairro = rs.getString("bairro");
                String complemento = rs.getString("complemento");
                String telefone = rs.getString("telefone");
                String telefoneopcional = rs.getString("telefone2");
                int numero = rs.getInt("numero");
                boolean administrador = rs.getBoolean("administrador");
                String user = rs.getString("nomedeusuario");
                String senha = rs.getString("senha");
                LocalDate data = rs.getDate("datadecadastro").toLocalDate();
                String email = rs.getString("email");
                String cpf = rs.getString("cpf");
                String estado = rs.getString("estado");
                double salario = rs.getDouble("salario");

                usuarios.add(new Usuario(user, senha, cpf, nome, cidade, rua, bairro, numero, complemento, estado, telefone, telefoneopcional, email, data, administrador, salario));
            }

            rs.close();
            stat.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao recuperar usuário.");
        } finally {
            disconnect();
        }

        return usuarios;
    }
}