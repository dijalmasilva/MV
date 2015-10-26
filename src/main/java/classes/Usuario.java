package classes;

import java.time.LocalDate;

public class Usuario {

    private String user;
    private String senha;
    private String cpf;
    private String nome;
    private String cidade;
    private String rua;
    private String bairro;
    private int numero;
    private String complemento;
    private String estado;
    private String telefone;
    private String telefoneOpcional;
    private String email;
    private LocalDate data;
    private double salario;
    private boolean administrador;

    public Usuario(String user, String senha, String cpf, String nome, String cidade, String rua, String bairro, int numero, String complemento, String estado, String telefone, String telefoneOpcional, String email, LocalDate data, boolean administrador, double salario) {
        this.user = user;
        this.senha = senha;
        this.cpf = cpf;
        this.nome = nome;
        this.cidade = cidade;
        this.rua = rua;
        this.bairro = bairro;
        this.numero = numero;
        this.complemento = complemento;
        this.estado = estado;
        this.telefone = telefone;
        this.telefoneOpcional = telefoneOpcional;
        this.email = email;
        this.data = data;
        this.administrador = administrador;
        this.salario = salario;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelefoneOpcional() {
        return telefoneOpcional;
    }

    public void setTelefoneOpcional(String telefoneOpcional) {
        this.telefoneOpcional = telefoneOpcional;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public boolean isAdministrador() {
        return administrador;
    }

    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }
}