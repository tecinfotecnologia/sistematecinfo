 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.techsistema.cont;

/**
 *
 * @author ALMEIDA
 */
public class Cidades {

    private int codigo;
    private String nome;
    private String uf;
    private String pais;
    
    
    public Cidades(){
        this.codigo = 0;
        this.nome = "";
        this.uf = "";
        this.pais = "";
    }
    
    public Cidades (int codigo){
        this.codigo = codigo;
        this.nome = "";
        this.uf = "";
        this.pais = "";
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

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return getNome();
    }
    
    
    
            
    
            
            
    
}
