package com.techsistema.tm;

import com.techsistema.cont.Cliente;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * Classe que define o modelo para tabela contendo dados do cliente
 *
 * @author Almeida
 */
public class ClienteTableModel extends AbstractTableModel {
    private final SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");
 //   private String colunas[] = {"Codigo", "Nome", "CPF", "Data Nascimento", "Fone", "Tipo", "Endereco", "Numero", "Bairro", "Cidade"};
    private String colunas[] = {"Codigo", "Nome", "CPF"};
    private List<Cliente> dados;

    @Override
    public int getRowCount() {
        if(dados == null){
            return 0;
        }
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int l, int c) {
        Cliente cliente = dados.get(l);
        switch (c) {
            case 0:
                return cliente.getCodigo();
            case 1:
                return cliente.getNome();
            case 2:
                return cliente.getCpf();
            case 3:
                return SDF.format(cliente.getDataNascimento());
             //   return SDF.format(venda.getDataVenda());
            case 4:
                return cliente.getFone();
            case 5:
                return cliente.getTipo();
            case 6:
                return cliente.getEndereco();
            case 7:
                return cliente.getNumero();
            case 8:
                return cliente.getBairro();
            case 9:
                return cliente.getCidade();
             case 10:
                return cliente.getCep();
            default:
                throw new IndexOutOfBoundsException("Coluna inexistente!");
        }
    }

    @Override
    public String getColumnName(int c) {
        return colunas[c];
    }

    @Override
    public boolean isCellEditable(int l, int c) {
        return false;
    }

    public void setDados(List<Cliente> dados) {
        this.dados = dados;
        fireTableDataChanged();
    }

    public Cliente getRowValue(int l) {
        return dados.get(l);
    }

   
}
