package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class CriarBanco {

    private Connection con;
    private String url;
    private final String user;
    private final String password;

    public CriarBanco() {
        url = "jdbc:postgresql://localhost:5432/";
        user = "postgres";
        password = "manoeldj20";
        criaOBanco();
    }

    public void connect() {
        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao se conectar com o banco!");
        }
    }

    public void disconnect() {
        try {
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao desconectar do banco!");
        }
    }

    public final void criaOBanco() {
        connect();
        try {
            Statement stat = con.createStatement();
            String sql = "create database MV";
            stat.executeUpdate(sql);
            criarTabelas();
            stat.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            disconnect();
        }
    }

    public void criarTabelas() {
        url = "jdbc:postgresql://localhost:5432/mv";
        connect();

        try {
            Statement stat = con.createStatement();
            String sql = "create table cliente (\n\tcpf varchar(14) unique not null,\n\tnome varchar(40) not null,\n\tcidade varchar(40) not null,\n\trua varchar(50) not null,\n\tnumero varchar(10) not null,\n\tbairro varchar(30) not null,\n\tlimite numeric(10,2) not null,\n\ttelefone varchar(16) not null,\n\temail varchar(50),\n\tdataDeCadastro date not null,\n\tcomplemento varchar(40),\n\ttelefone2 varchar(16),\n\testado varchar(40) not null,\n\n\tprimary key (cpf)\n);";

            stat.executeUpdate(sql);

            sql = "create table produto (\n\tcodigo varchar(30) unique not null,\n\tnome varchar(50) not null,\n\tvalorentrada numeric (10,2) not null,\n\tvalorsaida numeric(10,2) not null,\n\tdesconto int not null,\n\n\tprimary key(codigo)\n);";

            stat.executeUpdate(sql);
            sql = "create table estoque(\n\tidProduto varchar(30) not null unique,\n\tdataDeEntrada date not null,\n\tquantidade integer not null,\n\n\tprimary key (idProduto),\n\tforeign key (idProduto) references produto(codigo)\n);";

            stat.executeUpdate(sql);
            sql = "create table venda(\n\tid serial not null unique,\n\ttipoPagamento varchar(40) not null,\n\ttotal numeric(10,2) not null,\n\tcpfCliente varchar(14),\n\tdatadaVenda date,\n\tqtdeParcelas integer,\n\n\tprimary key (id),\n\tforeign key (cpfCliente) references cliente (cpf)\n);";

            stat.executeUpdate(sql);
            sql = "create table itemDeVenda(\n\tid serial not null unique,\n\tquantidade integer not null,\n\tsubTotal numeric(10, 2) not null,\n\tcodigoProduto varchar(30) not null,\n\tidVenda integer not null,\n\n\tprimary key(id),\n\tforeign key (codigoProduto) references produto(codigo),\n\tforeign key (idVenda) references venda (id)\n);";

            stat.executeUpdate(sql);
            sql = "create table parcelas (\n\tid serial unique,\n\tidVenda integer not null,\n\tvalor numeric(10,2) not null,\n\tdatadevencimento date not null,\n\tisPago boolean not null,\n\n\tprimary key (id),\n\tforeign key (idVenda) references venda (id)\n);";

            stat.executeUpdate(sql);
            sql = "create table usuario (\n\tcpf varchar(14) not null unique,\n\tnome varchar(40) not null,\n\tcidade varchar(40) not null,\n\trua varchar(50) not null,\n\tnumero varchar(10) not null,\n\tbairro varchar(40) not null,\n\ttelefone varchar(16) not null,\n\temail varchar(50),\n\tdatadecadastro date not null,\n\tcomplemento varchar(40),\n\ttelefone2 varchar(16),\n\tnomedeusuario varchar(40) not null unique,\n\tsenha varchar(20) not null,\n\tadministrador boolean not null,\n\testado varchar(40) not null,\n\tsalario numeric(10,2) not null,\n\n\tprimary key (nomedeusuario)\n);";

            stat.executeUpdate(sql);
            stat.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            disconnect();
        }
    }
}