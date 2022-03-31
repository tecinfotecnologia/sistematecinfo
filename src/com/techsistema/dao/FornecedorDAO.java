package com.techsistema.dao;

import com.techsistema.cont.Fornecedor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Classe de acesso a dados do fornecedor
 *
 * @author Juliano
 */
public class FornecedorDAO implements IDAO<Fornecedor> {

    @Override
    public void inserir(Fornecedor fornecedor) throws Exception {
        Conexao c = new Conexao();
        String sql = "INSERT INTO TBFORNECEDOR (NOME, CNPJ, FONE) VALUES (?, ?, ?)";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setString(1, fornecedor.getNome());
        ps.setString(2, fornecedor.getCnpj());
        ps.setString(3, fornecedor.getFone());
        ps.execute();
        c.confirmar();
    }

    @Override
    public void alterar(Fornecedor fornecedor) throws Exception {
        Conexao c = new Conexao();
        String sql = "UPDATE TBFORNECEDOR SET NOME=?, CNPJ=?, FONE=? WHERE CODIGO=?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setString(1, fornecedor.getNome());
        ps.setString(2, fornecedor.getCnpj());
        ps.setString(3, fornecedor.getFone());
        ps.setInt(4, fornecedor.getCodigo());
        ps.execute();
        c.confirmar();
    }

    @Override
    public void excluir(Fornecedor fornecedor) throws Exception {
        Conexao c = new Conexao();
        String sql = "DELETE FROM TBFORNECEDOR WHERE CODIGO=?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setInt(1, fornecedor.getCodigo());
        ps.execute();
        c.confirmar();
    }

    @Override
    public ArrayList<Fornecedor> listarTodos() throws Exception {
        Conexao c = new Conexao();
        String sql = "SELECT * FROM TBFORNECEDOR ORDER BY NOME";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        ArrayList listaFornecedors = new ArrayList();
        while (rs.next()) {
            Fornecedor fornecedor = new Fornecedor();
            fornecedor.setCodigo(rs.getInt("CODIGO"));
            fornecedor.setNome(rs.getString("NOME"));
            fornecedor.setCnpj(rs.getString("CNPJ"));
            fornecedor.setFone(rs.getString("FONE"));
            listaFornecedors.add(fornecedor);
        }

        return listaFornecedors;
    }

    @Override
    public Fornecedor recuperar(int codigo) throws Exception {
        Conexao c = new Conexao();
        String sql = "SELECT * FROM TBFORNECEDOR WHERE CODIGO=?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setInt(1, codigo);
        ResultSet rs = ps.executeQuery();

        Fornecedor fornecedor = new Fornecedor();
        if (rs.next()) {
            fornecedor.setCodigo(rs.getInt("CODIGO"));
            fornecedor.setNome(rs.getString("NOME"));
            fornecedor.setCnpj(rs.getString("CNPJ"));
            fornecedor.setFone(rs.getString("FONE"));
        }

        return fornecedor;
    }
}
