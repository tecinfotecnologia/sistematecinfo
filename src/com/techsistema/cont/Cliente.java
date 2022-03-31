package com.techsistema.cont;

import java.util.Date;


/**
 * Classe contendo os dados do cliente
 *
 * @author Almeida
 */
public class Cliente {

    private int codigo;
    private String nome;
    private String cpf;
    private Date dataNascimento;
    private String fone;
    private String tipo;
    private String endereco;
    private String numero;
    private String bairro;
    private String cidade;
    private String cep;

    public Cliente() {
        this.codigo = 0;
        this.nome = "";
        this.cpf = "";
        this.dataNascimento = new Date();
        this.fone = "";
        this.tipo = "";
        this.endereco = "";
        this.numero = "";
        this.bairro = "";
        this.cidade = "";
        this.cep = "";
                
    }

    public Cliente(int codigo) {
        this.codigo = codigo;
        this.nome = "";
        this.cpf = "";
        this.dataNascimento = new Date();
        this.fone = "";
        this.tipo = "";
        this.endereco = "";
        this.numero = "";
        this.bairro = "";
        this.cidade = "";
        this.cep = "";
        
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    
    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return getNome();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Cliente) {
            Cliente c = (Cliente) o;
            if (c.getCodigo() == this.getCodigo()) {
                return true;
            }
        }
        return false;
    }
   
}
