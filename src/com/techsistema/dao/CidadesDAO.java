/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.techsistema.dao;

import com.techsistema.cont.Cidades;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ALMEIDA
 */
public class CidadesDAO implements IDAO<Cidades>{
    
    public void inserir (Cidades cidades) throws Exception{
        Conexao c = new Conexao();
        String sql = "INSERT INTO TBCIDADES (NOME, UF, PAIS) VALUES(?, ?, ?)";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setString(1, cidades.getNome());
        ps.setString(2, cidades.getUf());
        ps.setString(3, cidades.getPais());
        ps.execute();
        c.confirmar();
        
    }

    @Override
    public void alterar(Cidades cidades) throws Exception {
        Conexao c = new Conexao();
        String sql = "UPDATE TBCIDADES SET NOME=?, UF=?, PAIS=? WHERE CODIGO=?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setString(1, cidades.getNome());
        ps.setString(2, cidades.getUf());
        ps.setString(3, cidades.getPais());
        ps.setInt(4, cidades.getCodigo());
        ps.execute();
        c.confirmar();
    }

    @Override
    public void excluir(Cidades cidades) throws Exception {
        Conexao c = new Conexao();
        String sql = "DELETE FROM TBCIDADES WHERE CODIGO=?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setInt(1, cidades.getCodigo());
        ps.execute();
        c.confirmar();
    }

    @Override
    public ArrayList<Cidades> listarTodos() throws Exception {
        Conexao c = new Conexao();
        String sql = "SELECT * FROM TBCIDADES ORDER BY NOME";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        ArrayList listaCidades = new ArrayList();
        while (rs.next()) {
            Cidades cidades = new Cidades();
            cidades.setCodigo(rs.getInt("CODIGO"));
            cidades.setNome(rs.getString("NOME"));
            cidades.setUf(rs.getString("UF"));
            cidades.setPais(rs.getString("PAIS"));
            listaCidades.add(cidades);
        }

        return listaCidades;
    }

    @Override
    public Cidades recuperar(int codigo) throws Exception {
        Conexao c = new Conexao();
        String sql = "SELECT * FROM TBCIDADES WHRE CODIGO=?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setInt(1, codigo);
        ResultSet rs = ps.executeQuery();
        
        Cidades cidades = new Cidades();
        if (rs.next()){
            cidades.setCodigo(rs.getInt("CODIGO"));
            cidades.setNome(rs.getString("NOME"));
            cidades.setUf(rs.getString("UF"));
            cidades.setPais(rs.getString("PAIS"));
        }
         return cidades;   
        
    }

    
}
