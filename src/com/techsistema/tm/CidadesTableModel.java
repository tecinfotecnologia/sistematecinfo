/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.techsistema.tm;

import com.techsistema.cont.Cidades;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ALMEIDA
 */
public class CidadesTableModel extends AbstractTableModel{
    
    private String colunas[] = {"Nome", "Uf", "Pais"};
    private List<Cidades> dados;
    
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
        Cidades cidades = dados.get(l);
        switch (c) {
            case 0:
                return cidades.getNome();
            case 1:
                return cidades.getUf();
            case 2:
                return cidades.getPais();
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

    public void setDados(List<Cidades> dados) {
        this.dados = dados;
        fireTableDataChanged();
    }

    public Cidades getRowValue(int l) {
        return dados.get(l);
    }
}
