/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import classes.Studant;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class FrStudant extends javax.swing.JFrame {

    Studant StudantEditando;
    List<Studant> lista;
    
    public FrStudant() {
        lista = new ArrayList<>();
        this.StudantEditando = null;
        initComponents();
        this.habilitarCampos(false);
        this.limparCampos();
        this.loadStudants();
    }
    
    public String createStudantListCSV(){
        String texto = "";
        Studant a = new Studant();
        texto = a.cabecalho();
        
        for(int i=0; i <= this.lista.size()-1; i++){
            Studant p = this.lista.get(i);
            texto = texto + p.atributoToCSV();
        }
        return texto;
    }
    
    public void saveStudant(String texto){
        FileWriter arq = null;
        try {
            arq = new FileWriter("ListaStudants.csv");
            PrintWriter gravaArq = new PrintWriter(arq);
            gravaArq.print(texto);
            arq.close();
        } catch (IOException ex) {
            Logger.getLogger(FrStudant.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                arq.close();
            } catch (IOException ex) {
                Logger.getLogger(FrStudant.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void loadStudants(){
        FileReader f  = null;
        try {
            f = new FileReader("ListaStudants.csv");
            Scanner arquivoLido = new Scanner(f);
            arquivoLido.useDelimiter("\n");
            this.lista = new ArrayList<>();
            String linhaLida = arquivoLido.next();
            while(arquivoLido.hasNext()){
                linhaLida = arquivoLido.next();
                
                Studant p = new Studant();
                p.CSVToAtributo(linhaLida);
                this.lista.add(p);
            } 
            edtListagem.setText(printStudantsList());
            arquivoLido.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrStudant.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                f.close();
            } catch (IOException ex) {
                Logger.getLogger(FrStudant.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }    
    
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        edtsex = new javax.swing.JTextField();
        lblage = new javax.swing.JLabel();
        lblMatricula = new javax.swing.JLabel();
        btnExcluir = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        edtage = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        edtMatricula = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        lblNome = new javax.swing.JLabel();
        edtNome = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        bntEditar = new javax.swing.JButton();
        lblsex = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        edtListagem = new javax.swing.JTextArea();
        lblAnoIngresso = new javax.swing.JLabel();
        edtAnoIngresso = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(70, 70, 70));

        edtsex.setBackground(new java.awt.Color(60, 60, 60));
        edtsex.setForeground(new java.awt.Color(255, 255, 255));
        edtsex.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 30, 30)));
        edtsex.setCaretColor(new java.awt.Color(255, 255, 255));
        edtsex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtsexActionPerformed(evt);
            }
        });

        lblage.setForeground(new java.awt.Color(255, 255, 255));
        lblage.setText("age:");

        lblMatricula.setForeground(new java.awt.Color(255, 255, 255));
        lblMatricula.setText("Matrícula:");

        btnExcluir.setBackground(new java.awt.Color(60, 60, 60));
        btnExcluir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnExcluir.setForeground(new java.awt.Color(255, 255, 255));
        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excluir.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 30, 30)));
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnNovo.setBackground(new java.awt.Color(60, 60, 60));
        btnNovo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnNovo.setForeground(new java.awt.Color(255, 255, 255));
        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/novo.png"))); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 30, 30)));
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        edtage.setBackground(new java.awt.Color(60, 60, 60));
        edtage.setForeground(new java.awt.Color(255, 255, 255));
        edtage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 30, 30)));
        edtage.setCaretColor(new java.awt.Color(255, 255, 255));
        edtage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtageActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(60, 60, 60));
        btnCancelar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 30, 30)));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        edtMatricula.setBackground(new java.awt.Color(60, 60, 60));
        edtMatricula.setForeground(new java.awt.Color(255, 255, 255));
        edtMatricula.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 30, 30)));
        edtMatricula.setCaretColor(new java.awt.Color(255, 255, 255));

        btnSalvar.setBackground(new java.awt.Color(60, 60, 60));
        btnSalvar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSalvar.setForeground(new java.awt.Color(255, 255, 255));
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/salvar.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 30, 30)));
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        lblNome.setForeground(new java.awt.Color(255, 255, 255));
        lblNome.setText("Nome: ");

        edtNome.setBackground(new java.awt.Color(60, 60, 60));
        edtNome.setForeground(new java.awt.Color(255, 255, 255));
        edtNome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 30, 30)));
        edtNome.setCaretColor(new java.awt.Color(255, 255, 255));
        edtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtNomeActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arcane Nine", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CADASTRO DO ALUNO");

        bntEditar.setBackground(new java.awt.Color(60, 60, 60));
        bntEditar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bntEditar.setForeground(new java.awt.Color(255, 255, 255));
        bntEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/editar.png"))); // NOI18N
        bntEditar.setText("Editar");
        bntEditar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 30, 30)));
        bntEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntEditarActionPerformed(evt);
            }
        });

        lblsex.setForeground(new java.awt.Color(255, 255, 255));
        lblsex.setText("sex:");

        edtListagem.setBackground(new java.awt.Color(60, 60, 60));
        edtListagem.setColumns(20);
        edtListagem.setForeground(new java.awt.Color(255, 255, 255));
        edtListagem.setRows(5);
        edtListagem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 30, 30)));
        jScrollPane1.setViewportView(edtListagem);

        lblAnoIngresso.setForeground(new java.awt.Color(255, 255, 255));
        lblAnoIngresso.setText("Ano de Ingresso:");

        edtAnoIngresso.setBackground(new java.awt.Color(60, 60, 60));
        edtAnoIngresso.setForeground(new java.awt.Color(255, 255, 255));
        edtAnoIngresso.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 30, 30)));
        edtAnoIngresso.setCaretColor(new java.awt.Color(255, 255, 255));
        edtAnoIngresso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtAnoIngressoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblAnoIngresso)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(edtAnoIngresso, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblMatricula)
                                    .addComponent(lblNome))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(edtNome)
                                    .addComponent(edtMatricula, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblage)
                            .addComponent(lblsex))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(edtsex)
                            .addComponent(edtage, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE))))
                .addGap(132, 132, 132))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNome)
                    .addComponent(edtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblsex)
                    .addComponent(edtsex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bntEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMatricula)
                    .addComponent(edtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblage)
                    .addComponent(edtage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAnoIngresso)
                            .addComponent(edtAnoIngresso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 571, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        this.habilitarCampos(true);
        this.limparCampos();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void bntEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntEditarActionPerformed
        String matriculaEscolhida = JOptionPane.showInputDialog("Informe a Matrícula do aluno que deseja editar: ", "");

        StudantEditando = this.searchStudant(matriculaEscolhida);
        if (StudantEditando == null){
            JOptionPane.showMessageDialog(this, "Não existe um aluno com essa Matrícula!");
        }else{
            this.limparCampos();
            this.habilitarCampos(true);
            this.objectToFields(StudantEditando);
        }
    }//GEN-LAST:event_bntEditarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.limparCampos();
        this.habilitarCampos(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        String cpfEscolhido= JOptionPane.showInputDialog("Informe a Matrícula do Aluno que deseja excluir: ", "");

        Studant p = this.searchStudant(cpfEscolhido);
        if(p == null){
            JOptionPane.showMessageDialog(this, "Não existe um Aluno com essa Matrícula.");
        }else{
            lista.remove(p);
            JOptionPane.showMessageDialog(this, "Aluno excluído com sucesso!");
        }

        edtListagem.setText(this.printStudantsList());
    }//GEN-LAST:event_btnExcluirActionPerformed
    
    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if(this.StudantEditando == null){
            Studant a = new Studant();
            a = this.fieldsToObject();
            lista.add(a);
        }else{
            this.lista.remove(this.StudantEditando);
            this.StudantEditando = this.fieldsToObject();
            this.lista.add(StudantEditando);
        }
        this.limparCampos();
        this.habilitarCampos(false);

        edtListagem.setText(this.printStudantsList());
        String texto = this.createStudantListCSV();
        this.saveStudant(texto);
    }//GEN-LAST:event_btnSalvarActionPerformed
    
    public String printStudantsList(){
        String listagemTotal = "";
        
        for(int i=0; i<= lista.size()-1; i++){
            listagemTotal += lista.get(i).toString();
        }
        return listagemTotal;
    }
    
    public Studant fieldsToObject(){
        Studant a = new Studant();
        a.setName(edtNome.getText());
        
        String sex = edtsex.getText();
        if(!sex.isEmpty()){
            a.setSex(edtsex.getText().charAt(0));
        }
        
        int i = 0;
        String age = edtage.getText();
        if(!age.isEmpty()){
            i = Integer.parseInt(edtage.getText());
        }
        a.setAge(i);
        
        a.setMatricula(edtMatricula.getText());
        
        int j = 0;
        String anoIngresso = edtAnoIngresso.getText();
        if(!anoIngresso.isEmpty()){
            j = Integer.parseInt(edtAnoIngresso.getText());
        }
        a.setAnoIngresso(j);
        
        return a;
    }
    
    private void objectToFields(Studant a) {
        edtNome.setText(a.getName());
        edtsex.setText(a.getSex() + "");
        edtage.setText(a.getAge() + "");
        edtAnoIngresso.setText(a.getAnoIngresso() + "");
        edtMatricula.setText(a.getMatricula() + "");

    }
    
    public Studant searchStudant(String matricula){
        for(int i=0; i <= lista.size()-1; i++){
            if(lista.get(i).getMatricula().equals(matricula))
                return lista.get(i);
        }
        return null;
    }
    
    public void habilitarCampos(boolean flag){
        edtNome.setEnabled(flag);
        edtsex.setEnabled(flag);
        edtage.setEnabled(flag);
        edtAnoIngresso.setEnabled(flag);
        edtMatricula.setEnabled(flag);
    }
    
    public void limparCampos(){
        edtNome.setText("");
        edtsex.setText("");
        edtage.setText("");
        edtAnoIngresso.setText("");
        edtMatricula.setText("");
    }
    
    private void edtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtNomeActionPerformed

    private void edtageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtageActionPerformed

    private void edtsexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtsexActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtsexActionPerformed

    private void edtAnoIngressoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtAnoIngressoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtAnoIngressoActionPerformed

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
            java.util.logging.Logger.getLogger(FrStudant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrStudant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrStudant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrStudant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrStudant().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntEditar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JTextField edtAnoIngresso;
    private javax.swing.JTextField edtage;
    private javax.swing.JTextArea edtListagem;
    private javax.swing.JTextField edtMatricula;
    private javax.swing.JTextField edtNome;
    private javax.swing.JTextField edtsex;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAnoIngresso;
    private javax.swing.JLabel lblage;
    private javax.swing.JLabel lblMatricula;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblsex;
    // End of variables declaration//GEN-END:variables
}
