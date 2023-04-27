/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Editora;
import model.Livro;
import services.EditoraServicos;
import services.LivroServicos;
import services.ServicosFactory;
import util.Validadores;

/**
 *
 * @author jbferraz
 */
public class jfLivro extends javax.swing.JFrame {

    /**
     * Creates new form jfLivro
     */
    public jfLivro() {
        initComponents();
        addRowToTable();
        jbDeletar.setVisible(false);
        this.setLocationRelativeTo(null);
    }

    public boolean validaInputs() {
        if (jtfTitulo.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Preencher nome!");
            jtfTitulo.requestFocus();
            return false;
        } else if (jtfISBN.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Preencher CPF!");
            jtfISBN.requestFocus();
            return false;
        } else if (jtfAssunto.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Preencher endereço!");
            jtfAssunto.requestFocus();
            return false;
        } else if (jtfAutor.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Preencher autor!");
            jtfAutor.requestFocus();
            return false;
        } else if (jtfEstoque.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Preencher gerente!");
            jtfEstoque.requestFocus();
            return false;
        } else if (jtfPreco.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Preencher preço!");
            jtfPreco.requestFocus();
            return false;
        } else if (jtfCNPJ.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Preencher CNPJ Livro!");
            jtfCNPJ.requestFocus();
            return false;
        }
        return true;
    }//fim validaInputs

    public void addRowToTable() {
        DefaultTableModel model = (DefaultTableModel) jtLivros.getModel();
        model.getDataVector().removeAllElements();//remove todas as linhas
        model.fireTableDataChanged();
        Object rowData[] = new Object[4];
        LivroServicos livroS = ServicosFactory.getLivroServicos();
        for (Livro li : livroS.buscaLivros()) {
            rowData[0] = li.getIsbn();
            rowData[1] = li.getTitulo();
            rowData[2] = li.getAssunto();
            rowData[3] = li.getIdEditora().getNmEditora();
            model.addRow(rowData);
        }
    }

    public void somenteNum(java.awt.event.KeyEvent evt) {
        String number = "0123456789";
        if (jtfISBN.getText().length() < 14) {
            if (!number.contains(evt.getKeyChar() + "")) {
                evt.consume();
            }
        } else {
            evt.consume();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtfAssunto = new javax.swing.JTextField();
        jtfISBN = new javax.swing.JTextField();
        jtfTitulo = new javax.swing.JTextField();
        jbSalvar = new javax.swing.JButton();
        jbFechar = new javax.swing.JButton();
        jbEditar = new javax.swing.JButton();
        jbLimpar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtLivros = new javax.swing.JTable();
        jbDeletar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jtfEstoque = new javax.swing.JTextField();
        jtfAutor = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtfPreco = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jtfCNPJ = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerência Cliente");

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 102, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gerência Livro");

        jLabel2.setText("* Título:");

        jLabel3.setText("* ISBN:");

        jLabel4.setText("* Assunto:");

        jLabel5.setText("* Autor:");

        jtfAssunto.setToolTipText("Endereço completo.");

        jtfISBN.setToolTipText("Informe somente números.");
        jtfISBN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfISBNKeyTyped(evt);
            }
        });

        jtfTitulo.setToolTipText("Informe o nome completo.");
        jtfTitulo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfTituloKeyTyped(evt);
            }
        });

        jbSalvar.setMnemonic('S');
        jbSalvar.setText("Salvar");
        jbSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalvarActionPerformed(evt);
            }
        });

        jbFechar.setMnemonic('F');
        jbFechar.setText("Fechar");
        jbFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbFecharActionPerformed(evt);
            }
        });

        jbEditar.setMnemonic('E');
        jbEditar.setText("Editar");
        jbEditar.setEnabled(false);
        jbEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditarActionPerformed(evt);
            }
        });

        jbLimpar.setMnemonic('L');
        jbLimpar.setText("Limpar");
        jbLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimparActionPerformed(evt);
            }
        });

        jtLivros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "ISBN", "Título", "Assunto", "Editora"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtLivros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtLivrosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtLivros);

        jbDeletar.setMnemonic('D');
        jbDeletar.setText("Deletar");
        jbDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDeletarActionPerformed(evt);
            }
        });

        jLabel6.setText("* Estoque:");

        jtfEstoque.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfEstoqueKeyTyped(evt);
            }
        });

        jLabel7.setText("* Preço:");

        jLabel8.setText("* Editora:");

        jtfCNPJ.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfCNPJFocusLost(evt);
            }
        });
        jtfCNPJ.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfCNPJKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbDeletar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jtfISBN, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtfAutor))
                    .addComponent(jtfTitulo)
                    .addComponent(jtfAssunto, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(10, 10, 10))
            .addComponent(jSeparator2)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtfEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtfPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfCNPJ)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtfISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jtfAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtfAssunto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jtfEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(11, 11, 11))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addGap(18, 18, 18)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbSalvar)
                    .addComponent(jbFechar)
                    .addComponent(jbEditar)
                    .addComponent(jbLimpar)
                    .addComponent(jbDeletar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(191, 191, 191))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 419, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfISBNKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfISBNKeyTyped
        // TODO add your handling code here:
        somenteNum(evt);
    }//GEN-LAST:event_jtfISBNKeyTyped

    private void jtfTituloKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfTituloKeyTyped
        // TODO add your handling code here:
        String nletras = "0123456789<>:?/~^}][{´`=+-_!|'\'@#$%¨&*()²³£¢¬§º°ª";
        if (nletras.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_jtfTituloKeyTyped

    private void jbFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFecharActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jbFecharActionPerformed

    private void jbLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimparActionPerformed
        // TODO add your handling code here:
        if (jbLimpar.getText().equals("Limpar")) {
            limparCampos();
        } else {
            limparCampos();
            btnDefault();
        }
    }//GEN-LAST:event_jbLimparActionPerformed

    public void btnDefault() {
        jbLimpar.setText("Limpar");
        jbSalvar.setText("Salvar");
        jbEditar.setEnabled(false);
        jtfISBN.setEnabled(true);
        jtfCNPJ.setEnabled(true);
        jbDeletar.setVisible(false);
    }

    public void limparCampos() {
        jtfISBN.setText("");
        jtfAssunto.setText("");
        jtfAutor.setText("");
        jtfTitulo.setText("");
        jtfCNPJ.setText("");
        jtfEstoque.setText("");
        jtfPreco.setText("");
        jtfTitulo.requestFocus();
    }

    private void jtLivrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtLivrosMouseClicked
        // TODO add your handling code here:
        jbEditar.setEnabled(true);
        jbDeletar.setVisible(true);
    }//GEN-LAST:event_jtLivrosMouseClicked

    private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarActionPerformed
        // TODO add your handling code here:
        if (validaInputs()) {
            //pegar dados da tela para salvar
            int idLivro = 0;
            String titulo = jtfTitulo.getText().toUpperCase();
            int estoque = Integer.parseInt(jtfEstoque.getText());
            String isbn = jtfISBN.getText();
            String assunto = jtfAssunto.getText().toUpperCase();
            String autor = jtfAutor.getText().toUpperCase();
            float preco = Float.parseFloat(jtfPreco.getText());
            EditoraServicos edS = ServicosFactory.getEditoraServicos();
            Editora ed = edS.buscarEditorabyCNPJ(jtfCNPJ.getText());
            LivroServicos livroS = ServicosFactory.getLivroServicos();

            Livro li = new Livro(idLivro, titulo, autor, assunto, isbn, estoque, preco, ed);
            if (jbSalvar.getText().equals("Salvar")) {
                livroS.cadastrarLivro(li);
            } else {
                livroS.atualizarLivro(li);
                jbLimpar.doClick();
            }

            limparCampos();
            addRowToTable();
        }
    }//GEN-LAST:event_jbSalvarActionPerformed

    private void jbEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarActionPerformed
        // TODO add your handling code here:
        jbSalvar.setText("Confirmar");
        jtfISBN.setEnabled(false);
        jtfCNPJ.setEnabled(false);
        jbLimpar.setText("Cancelar");
        jbDeletar.setVisible(false);

        //pegando dados da tabela e add em variaveis locais
        int linha;
        linha = jtLivros.getSelectedRow();
        String isbn = (String) jtLivros.getValueAt(linha, 0);
        LivroServicos livroS = ServicosFactory.getLivroServicos();
        Livro li = livroS.buscaLivroISBN(isbn);
        //carregar dados no form
        jtfISBN.setText(li.getIsbn());
        jtfTitulo.setText(li.getTitulo());
        jtfAssunto.setText(li.getAssunto());
        jtfAutor.setText(li.getAutor());
        jtfEstoque.setText(String.valueOf(li.getEstoque()));
        jtfPreco.setText(String.valueOf(li.getPreco()));
        jtfCNPJ.setText(li.getIdEditora().getCnpj());
        jtfTitulo.requestFocus();
    }//GEN-LAST:event_jbEditarActionPerformed

    private void jbDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDeletarActionPerformed
        // TODO add your handling code here:
        int linha;
        String cnpj;
        linha = jtLivros.getSelectedRow();
        cnpj = (String) jtLivros.getValueAt(linha, 0);
        LivroServicos livroS = ServicosFactory.getLivroServicos();
        Object[] resp = {"Sim", "Não"};
        int resposta = JOptionPane.showOptionDialog(this,
                "Deseja realmente deletar este CNPJ?", "Deletar",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.WARNING_MESSAGE,
                null, resp, resp[0]);
        if (resposta == 0) {
            livroS.deletarLivro(cnpj);
            addRowToTable();
            JOptionPane.showMessageDialog(this,
                    "Livro deletado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(this,
                    "Ok, entendo sua descisão!");
        }
        jbDeletar.setVisible(false);
    }//GEN-LAST:event_jbDeletarActionPerformed

    private void jtfEstoqueKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfEstoqueKeyTyped
        // TODO add your handling code here:
        somenteNum(evt);
    }//GEN-LAST:event_jtfEstoqueKeyTyped

    private void jtfCNPJKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCNPJKeyTyped
        // TODO add your handling code here:
        somenteNum(evt);
    }//GEN-LAST:event_jtfCNPJKeyTyped

    private void jtfCNPJFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfCNPJFocusLost
        // TODO add your handling code here:
        EditoraServicos edS = ServicosFactory.getEditoraServicos();
        Editora ed = edS.buscarEditorabyCNPJ(jtfCNPJ.getText());
        if (ed.getCnpj() == null) {
            JOptionPane.showMessageDialog(this, "Editora não cadastrada!",
                    "Pesquisa", JOptionPane.INFORMATION_MESSAGE);
        } else {
            Object[] resp = {"Sim", "Não"};
            int resposta = JOptionPane.showOptionDialog(this,
                    "Editora " + ed.getNmEditora() + " está correta?", "Pesquisa",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.WARNING_MESSAGE,
                    null, resp, resp[0]);
            if (resposta == 1) {
                jtfCNPJ.setText("");
                jtfCNPJ.requestFocus();
            }
        }
    }//GEN-LAST:event_jtfCNPJFocusLost

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(jfLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jfLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jfLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jfLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jfLivro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton jbDeletar;
    private javax.swing.JButton jbEditar;
    private javax.swing.JButton jbFechar;
    private javax.swing.JButton jbLimpar;
    private javax.swing.JButton jbSalvar;
    private javax.swing.JTable jtLivros;
    private javax.swing.JTextField jtfAssunto;
    private javax.swing.JTextField jtfAutor;
    private javax.swing.JTextField jtfCNPJ;
    private javax.swing.JTextField jtfEstoque;
    private javax.swing.JTextField jtfISBN;
    private javax.swing.JTextField jtfPreco;
    private javax.swing.JTextField jtfTitulo;
    // End of variables declaration//GEN-END:variables
}