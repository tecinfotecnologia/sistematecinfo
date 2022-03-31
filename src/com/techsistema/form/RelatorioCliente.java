package com.techsistema.form;

import com.techsistema.dao.ClienteDAO;
import com.techsistema.dao.Conexao;
import com.techsistema.tm.ClienteTableModel;
import com.techsistema.cont.Cliente;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 * Janela de cadastro de cliente
 *
 * @author Juliano
 */
public class RelatorioCliente extends javax.swing.JInternalFrame {

    private Cliente cliente = null;
    private ClienteDAO clienteDAO = new ClienteDAO();

    public RelatorioCliente() {
        initComponents();
        habilitarFormulario(false);
     //   carregarGrade();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnBarraFerramentas = new javax.swing.JPanel();
        barraFerramentas = new javax.swing.JToolBar();
        btCancelar = new javax.swing.JButton();
        btImprimir = new javax.swing.JButton();
        pnConteudo = new javax.swing.JPanel();
        pnForm = new javax.swing.JPanel();
        lbNome = new javax.swing.JLabel();
        lbCpf = new javax.swing.JLabel();
        lbDataNascimento = new javax.swing.JLabel();
        ftfNome = new javax.swing.JFormattedTextField();
        ftfCpf = new javax.swing.JFormattedTextField();
        ftfDataNascimento = new javax.swing.JFormattedTextField();
        ftfFone = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        lbFiltro = new javax.swing.JLabel();
        tfFiltro = new javax.swing.JTextField();
        btPesquisa = new javax.swing.JButton();
        spGrade = new javax.swing.JScrollPane();
        tbGrade = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("Relatório de Clientes x Nome");

        pnBarraFerramentas.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 0, 10));
        pnBarraFerramentas.setOpaque(false);
        pnBarraFerramentas.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        barraFerramentas.setFloatable(false);

        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/techsistema/form/img/cancelar.png"))); // NOI18N
        btCancelar.setText("Cancelar");
        btCancelar.setFocusable(false);
        btCancelar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btCancelar.setMargin(new java.awt.Insets(2, 8, 2, 8));
        btCancelar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/com/techsistema/form/img/cancelar-foco.png"))); // NOI18N
        btCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });
        barraFerramentas.add(btCancelar);

        btImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/techsistema/form/img/finalizar.png"))); // NOI18N
        btImprimir.setText("Imprimir");
        btImprimir.setFocusable(false);
        btImprimir.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btImprimir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btImprimir.setMargin(new java.awt.Insets(2, 8, 2, 8));
        btImprimir.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/com/techsistema/form/img/finalizar-foco.png"))); // NOI18N
        btImprimir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btImprimirActionPerformed(evt);
            }
        });
        barraFerramentas.add(btImprimir);

        pnBarraFerramentas.add(barraFerramentas);

        getContentPane().add(pnBarraFerramentas, java.awt.BorderLayout.PAGE_START);

        pnConteudo.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 10, 10));
        pnConteudo.setLayout(new java.awt.BorderLayout());

        pnForm.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(5, 0, 5, 0), javax.swing.BorderFactory.createTitledBorder(null, "Formulário", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(102, 153, 255)))); // NOI18N
        pnForm.setOpaque(false);
        pnForm.setPreferredSize(new java.awt.Dimension(369, 150));

        lbNome.setText("Nome:");

        lbCpf.setText("CPF:");

        lbDataNascimento.setText("Data Nascimento:");

        ftfNome.setColumns(25);

        ftfCpf.setColumns(10);
        try {
            ftfCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftfCpf.setValue(new String());

        ftfDataNascimento.setColumns(10);
        ftfDataNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        ftfDataNascimento.setValue(new Date());

        try {
            ftfFone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel1.setText("Fone:");

        lbFiltro.setText("Filtro:");

        tfFiltro.setColumns(30);
        tfFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfFiltroKeyReleased(evt);
            }
        });

        btPesquisa.setText("PESQUISA");
        btPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisaActionPerformed(evt);
            }
        });
        btPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btPesquisaKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout pnFormLayout = new javax.swing.GroupLayout(pnForm);
        pnForm.setLayout(pnFormLayout);
        pnFormLayout.setHorizontalGroup(
            pnFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnFormLayout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(lbCpf)
                        .addGap(4, 4, 4)
                        .addComponent(ftfCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ftfFone))
                    .addGroup(pnFormLayout.createSequentialGroup()
                        .addGroup(pnFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnFormLayout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(lbNome)
                                .addGap(4, 4, 4)
                                .addComponent(ftfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnFormLayout.createSequentialGroup()
                                .addComponent(lbDataNascimento)
                                .addGap(4, 4, 4)
                                .addComponent(ftfDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 42, Short.MAX_VALUE)))
                .addGap(10, 10, 10))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnFormLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbFiltro)
                .addGap(5, 5, 5)
                .addComponent(tfFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btPesquisa)
                .addGap(19, 19, 19))
        );
        pnFormLayout.setVerticalGroup(
            pnFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFormLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(pnFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnFormLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lbNome))
                    .addComponent(ftfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(pnFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnFormLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lbCpf))
                    .addGroup(pnFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ftfCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ftfFone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)))
                .addGap(4, 4, 4)
                .addGroup(pnFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnFormLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lbDataNascimento))
                    .addComponent(ftfDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(pnFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnFormLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lbFiltro))
                    .addGroup(pnFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btPesquisa)))
                .addContainerGap())
        );

        pnConteudo.add(pnForm, java.awt.BorderLayout.PAGE_START);

        tbGrade.setAutoCreateRowSorter(true);
        tbGrade.setModel(new ClienteTableModel());
        tbGrade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbGradeMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbGradeMousePressed(evt);
            }
        });
        spGrade.setViewportView(tbGrade);

        pnConteudo.add(spGrade, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnConteudo, java.awt.BorderLayout.CENTER);

        setBounds(10, 10, 405, 450);
    }// </editor-fold>//GEN-END:initComponents

    private void tbGradeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbGradeMouseClicked
        if (evt.getClickCount() == 2) {
            ClienteTableModel tm = (ClienteTableModel) tbGrade.getModel();
            cliente = tm.getRowValue(tbGrade.getRowSorter().convertRowIndexToModel(tbGrade.getSelectedRow()));

            ftfNome.setValue(cliente.getNome());
            ftfCpf.setValue(cliente.getCpf());
            ftfDataNascimento.setValue(cliente.getDataNascimento());
            ftfFone.setValue(cliente.getFone());

            habilitarFormulario(true);
        }
    }//GEN-LAST:event_tbGradeMouseClicked

    private void tfFiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfFiltroKeyReleased
    //    TableRowSorter rs = (TableRowSorter) tbGrade.getRowSorter();
   //     rs.setRowFilter(RowFilter.regexFilter("(?i)" + tfFiltro.getText(), 1, 2)); // DEFAUL 0, 1
   //     ClienteTableModel tm = (ClienteTableModel) tbGrade.getModel();
               
    }//GEN-LAST:event_tfFiltroKeyReleased

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        habilitarFormulario(false);
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btPesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btPesquisaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btPesquisaKeyPressed

    private void btPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisaActionPerformed

        ClienteTableModel tm = (ClienteTableModel) tbGrade.getModel();
 
        try {
            tm.setDados(clienteDAO.pesquisarPorNome(tfFiltro.getText()));
        } catch (Exception ex) {
            Logger.getLogger(RelatorioCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }//GEN-LAST:event_btPesquisaActionPerformed

    private void tbGradeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbGradeMousePressed
            ClienteTableModel tm = (ClienteTableModel) tbGrade.getModel();
            cliente = tm.getRowValue(tbGrade.getRowSorter().convertRowIndexToModel(tbGrade.getSelectedRow()));

            ftfNome.setValue(cliente.getNome());
            ftfCpf.setValue(cliente.getCpf());
            ftfDataNascimento.setValue(cliente.getDataNascimento());
            ftfFone.setValue(cliente.getFone());

    }//GEN-LAST:event_tbGradeMousePressed

    private void btImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btImprimirActionPerformed
        
        try {
            imprimeCliente();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RelatorioCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RelatorioCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(RelatorioCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btImprimirActionPerformed
    
    private void imprimeCliente() throws ClassNotFoundException, SQLException, JRException{
        Conexao c = new Conexao();
        
        int linhaSelecionada = tbGrade.getSelectedRow();
            ClienteTableModel vtm = (ClienteTableModel) tbGrade.getModel();
            cliente = vtm.getRowValue(linhaSelecionada);                
           
            JDialog viewer = new JDialog(new javax.swing.JFrame(), "Visualização do Relatório", true);
            viewer.setSize(1200, 800);
            viewer.setLocationRelativeTo(null);
            HashMap parametros = new HashMap();
            parametros.put("CODIGO", cliente.getCodigo());
        //    JasperPrint jp = JasperFillManager.fillReport("src/com/techsistema/rel/imprimeCliente.jasper", parametros, c.getConexao());
            JasperPrint jp = JasperFillManager.fillReport("C:\\techsistema\\src\\com\\techsistema\\rel\\imprimeCliente.jasper", parametros, c.getConexao());
            JasperViewer jrViewer = new JasperViewer(jp, true);
            viewer.getContentPane().add(jrViewer.getContentPane());
            viewer.setVisible(true);
    }
      
    
    private void habilitarFormulario(boolean ativo) {
    //    btNovo.setEnabled(!ativo);
    //    btSalvar.setEnabled(ativo);
    //    btExcluir.setEnabled(ativo);
        btCancelar.setEnabled(ativo);
        ftfNome.setEnabled(ativo);
        ftfCpf.setEnabled(ativo);
        ftfDataNascimento.setEnabled(ativo);
        ftfFone.setEnabled(ativo);
        tbGrade.setEnabled(!ativo);

        if (!ativo) {
            limpaFormulario();
        }
    }

    private void limpaFormulario() {
        cliente = null;
        ftfNome.setValue("");
        ftfCpf.setValue("");
        ftfDataNascimento.setValue(new Date());
        ftfFone.setValue("");
    }

    private boolean validarFormulario() {
        if (ftfNome.getText().trim().length() < 2) {
            JOptionPane.showMessageDialog(this, "Nome inválido.", "Alerta", JOptionPane.WARNING_MESSAGE);
            ftfNome.requestFocus();
            return false;
        }
        if (ftfCpf.getText().trim().length() != 14) {
            JOptionPane.showMessageDialog(this, "CPF inválido.", "Alerta", JOptionPane.WARNING_MESSAGE);
            ftfCpf.requestFocus();
            return false;
        }
        if (((Date) ftfDataNascimento.getValue()).after(new Date())) {
            JOptionPane.showMessageDialog(this, "Data de nascimento inválida.", "Alerta", JOptionPane.WARNING_MESSAGE);
            ftfDataNascimento.requestFocus();
            return false;
        }
        if (ftfFone.getText().trim().length() < 2) {
            JOptionPane.showMessageDialog(this, "Fone inválido.", "Alerta", JOptionPane.WARNING_MESSAGE);
            ftfFone.requestFocus();
            return false;
        }
        return true;
    }

    private void carregarGrade() {
        ClienteTableModel tm = (ClienteTableModel) tbGrade.getModel();
        try {
            tm.setDados(clienteDAO.listarTodos());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar grade.\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToolBar barraFerramentas;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btImprimir;
    private javax.swing.JButton btPesquisa;
    private javax.swing.JFormattedTextField ftfCpf;
    private javax.swing.JFormattedTextField ftfDataNascimento;
    private javax.swing.JFormattedTextField ftfFone;
    private javax.swing.JFormattedTextField ftfNome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbCpf;
    private javax.swing.JLabel lbDataNascimento;
    private javax.swing.JLabel lbFiltro;
    private javax.swing.JLabel lbNome;
    private javax.swing.JPanel pnBarraFerramentas;
    private javax.swing.JPanel pnConteudo;
    private javax.swing.JPanel pnForm;
    private javax.swing.JScrollPane spGrade;
    private javax.swing.JTable tbGrade;
    private javax.swing.JTextField tfFiltro;
    // End of variables declaration//GEN-END:variables
    }
