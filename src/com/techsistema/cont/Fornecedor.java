package com.techsistema.cont;

/**
 * Classe contendo os dados do fornecedor
 *
 * @author Juliano
 */
public class Fornecedor {

    private int codigo;
    private String nome;
    private String cnpj;
    private String fone;

    public Fornecedor() {
        this.codigo = 0;
        this.nome = "";
        this.cnpj = "";
        this.fone = "";
    }

    public Fornecedor(int codigo) {
        this.codigo = codigo;
        this.nome = "";
        this.cnpj = "";
        this.fone = "";
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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return getNome();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Fornecedor) {
            Fornecedor c = (Fornecedor) o;
            if (c.getCodigo() == this.getCodigo()) {
                return true;
            }
        }
        return false;
    }
}
