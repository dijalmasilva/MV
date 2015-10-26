package classes;

import java.time.LocalDate;

public class Cliente {

    private String cpf;
    private String nome;
    private String cidade;
    private String rua;
    private String bairro;
    private int numero;
    private String complemento;
    private String estado;
    private double limite;
    private String telefone;
    private String telefoneOpcional;
    private String email;
    private LocalDate data;

    public Cliente(String cpf, String nome, String cidade, String rua, String bairro, int numero, String complemento, String estado, double limite, String telefone, String email, String telefoneOpcional) {
        this.cpf = cpf;
        this.nome = nome;
        this.cidade = cidade;
        this.rua = rua;
        this.bairro = bairro;
        this.numero = numero;
        this.complemento = complemento;
        this.estado = estado;
        this.limite = limite;
        this.telefone = telefone;
        this.email = email;
        this.telefoneOpcional = telefoneOpcional;
        data = LocalDate.now();
    }

    public Cliente(String cpf, String nome, String cidade, String rua, String bairro, int numero, String complemento, String estado, double limite, String telefone, String email, String telefoneOpcional, LocalDate data) {
        this.cpf = cpf;
        this.nome = nome;
        this.cidade = cidade;
        this.rua = rua;
        this.bairro = bairro;
        this.numero = numero;
        this.complemento = complemento;
        this.estado = estado;
        this.limite = limite;
        this.telefone = telefone;
        this.email = email;
        this.telefoneOpcional = telefoneOpcional;
        this.data = data;
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

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
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

    public String getTelefoneOpcional() {
        return telefoneOpcional;
    }

    public void setTelefoneOpcional(String telefoneOpcional) {
        this.telefoneOpcional = telefoneOpcional;
  }
 }