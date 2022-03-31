package com.techsistema.dao;

import com.techsistema.cont.Cliente;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


/**
 * Classe de acesso a dados do cliente
 *
 * @author Juliano
 */
public class ClienteDAO implements IDAO<Cliente> {

    @Override
    public void inserir(Cliente cliente) throws Exception {
        Conexao c = new Conexao();
        String sql = "INSERT INTO TBCLIENTE (NOME, CPF, DATANASCIMENTO, FONE, TIPO, ENDERECO, NUMERO, BAIRRO, CIDADE, CEP) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setString(1, cliente.getNome());
        ps.setString(2, cliente.getCpf());
        ps.setDate(3, new Date(cliente.getDataNascimento().getTime()));
        ps.setString(4, cliente.getFone());
        ps.setString(5, cliente.getTipo());
        ps.setString(6, cliente.getEndereco());
        ps.setString(7, cliente.getNumero());
        ps.setString(8, cliente.getBairro());
        ps.setString(9, cliente.getCidade());
        ps.setString(10, cliente.getCep());
        ps.execute();
        c.confirmar();
    }

    @Override
    public void alterar(Cliente cliente) throws Exception {
        Conexao c = new Conexao();
        String sql = "UPDATE TBCLIENTE SET NOME=?, CPF=?, DATANASCIMENTO=?, FONE=?, TIPO=?, ENDERECO=?, NUMERO=?, BAIRRO=?, CIDADE=?, CEP=?  WHERE CODIGO=?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setString(1, cliente.getNome());
        ps.setString(2, cliente.getCpf());
        ps.setDate(3, new Date(cliente.getDataNascimento().getTime()));
        ps.setString(4, cliente.getFone());
        ps.setString(5, cliente.getTipo());
        ps.setString(6, cliente.getEndereco());
        ps.setString(7, cliente.getNumero());
        ps.setString(8, cliente.getBairro());
        ps.setString(9, cliente.getCidade());
        ps.setString(10, cliente.getCep());
        ps.setInt(11, cliente.getCodigo());
        ps.execute();
        c.confirmar();
    }

    @Override
    public void excluir(Cliente cliente) throws Exception {
        Conexao c = new Conexao();
        String sql = "DELETE FROM TBCLIENTE WHERE CODIGO=?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setInt(1, cliente.getCodigo());
        ps.execute();
        c.confirmar();
    }

    @Override
    public ArrayList<Cliente> listarTodos() throws Exception {
        Conexao c = new Conexao();
        String sql = "SELECT * FROM TBCLIENTE ORDER BY NOME";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        ArrayList listaClientes = new ArrayList();
        while (rs.next()) {
            Cliente cliente = new Cliente();
            cliente.setCodigo(rs.getInt("CODIGO"));
            cliente.setNome(rs.getString("NOME"));
            cliente.setCpf(rs.getString("CPF"));
            cliente.setDataNascimento(rs.getDate("DATANASCIMENTO"));
            cliente.setFone(rs.getString("FONE"));
            cliente.setTipo(rs.getString("TIPO"));
            cliente.setEndereco(rs.getString("ENDERECO"));
            cliente.setNumero(rs.getString("NUMERO"));
            cliente.setBairro(rs.getString("BAIRRO"));
            cliente.setCidade(rs.getString("CIDADE"));
            cliente.setCep(rs.getString("CEP"));
            listaClientes.add(cliente);
        }

        return listaClientes;
    }

    @Override
    public Cliente recuperar(int codigo) throws Exception {
        Conexao c = new Conexao();
        String sql = "SELECT * FROM TBCLIENTE WHERE CODIGO=?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setInt(1, codigo);
        ResultSet rs = ps.executeQuery();

        Cliente cliente = new Cliente();
        if (rs.next()) {
            cliente.setCodigo(rs.getInt("CODIGO"));
            cliente.setNome(rs.getString("NOME"));
            cliente.setCpf(rs.getString("CPF"));
            cliente.setDataNascimento(rs.getDate("DATANASCIMENTO"));
            cliente.setFone(rs.getString("FONE"));
            cliente.setTipo(rs.getString("TIPO"));
            cliente.setEndereco(rs.getString("ENDERECO"));
            cliente.setNumero(rs.getString("NUMERO"));
            cliente.setBairro(rs.getString("BAIRRO"));
            cliente.setCidade(rs.getString("CIDADE"));
            cliente.setCep(rs.getString("CEP"));
        }

        return cliente;
    }
    
   public ArrayList<Cliente> pesquisarPorNome(String nome) throws Exception {
        Conexao c = new Conexao();
        String sql = "SELECT * FROM TBCLIENTE WHERE NOME like ?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setString(1, '%' + nome + '%');
        ResultSet rs = ps.executeQuery();
         
        ArrayList listaClientes = new ArrayList();
        while (rs.next()) {
            Cliente cliente = new Cliente();
         
            cliente.setCodigo(rs.getInt("CODIGO"));
            cliente.setNome(rs.getString("NOME"));
            cliente.setCpf(rs.getString("CPF"));
            cliente.setDataNascimento(rs.getDate("DATANASCIMENTO"));
            cliente.setFone(rs.getString("FONE"));
            listaClientes.add(cliente);
        }

        return listaClientes;
    }
        
}
