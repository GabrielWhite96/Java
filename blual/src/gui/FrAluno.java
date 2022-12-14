/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import classes.Aluno;
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
public class FrAluno extends javax.swing.JFrame {

    Aluno alunoEditando;
    List<Aluno> lista;
    
    public FrAluno() {
        lista = new ArrayList<>();
        this.alunoEditando = null;
        initComponents();
        this.habilitarCampos(false);
        this.limparCampos();
        this.loadALunos();
    }
    
    public String criarListaAlunosCSV(){
        String texto = "";
        Aluno a = new Aluno();
        texto = a.cabecalho();
        
        for(int i=0; i <= this.lista.size()-1; i++){
            Aluno p = this.lista.get(i);
            texto = texto + p.atributoToCSV();
        }
        return texto;
    }
    
    public void salvarAlunos(String texto){
        FileWriter arq = null;
        try {
            arq = new FileWriter("ListaAlunos.csv");
            PrintWriter gravaArq = new PrintWriter(arq);
            gravaArq.print(texto);
            arq.close();
        } catch (IOException ex) {
            Logger.getLogger(FrAluno.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                arq.close();
            } catch (IOException ex) {
                Logger.getLogger(FrAluno.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void loadALunos(){
        FileReader f  = null;
        try {
            f = new FileReader("ListaAlunos.csv");
            Scanner arquivoLido = new Scanner(f);
            arquivoLido.useDelimiter("\n");
            this.lista = new ArrayList<>();
            String linhaLida = arquivoLido.next();
            while(arquivoLido.hasNext()){
                linhaLida = arquivoLido.next();
                
                Aluno p = new Aluno();
                p.CSVToAtributo(linhaLida);
                this.lista.add(p);
            }   edtListagem.setText(imprimirListaAlunos());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrAluno.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                f.close();
            } catch (IOException ex) {
                Logger.getLogger(FrAluno.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnNovo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        bntEditar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        lblNome = new javax.swing.JLabel();
        lblMatricula = new javax.swing.JLabel();
        lblSexo = new javax.swing.JLabel();
        lblIdade = new javax.swing.JLabel();
        lblAnoIngresso = new javax.swing.JLabel();
        edtMatricula = new javax.swing.JTextField();
        edtNome = new javax.swing.JTextField();
        edtIdade = new javax.swing.JTextField();
        edtSexo = new javax.swing.JTextField();
        edtAnoIngresso = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        edtListagem = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnNovo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/novo.png"))); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CADASTRO DO ALUNO");

        bntEditar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bntEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/editar.png"))); // NOI18N
        bntEditar.setText("Editar");
        bntEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntEditarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnExcluir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excluir.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnSalvar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/salvar.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        lblNome.setText("Nome: ");

        lblMatricula.setText("Matrícula:");

        lblSexo.setText("Sexo:");

        lblIdade.setText("Idade:");

        lblAnoIngresso.setText("Ano de Ingresso:");

        edtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtNomeActionPerformed(evt);
            }
        });

        edtIdade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtIdadeActionPerformed(evt);
            }
        });

        edtSexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtSexoActionPerformed(evt);
            }
        });

        edtAnoIngresso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtAnoIngressoActionPerformed(evt);
            }
        });

        edtListagem.setColumns(20);
        edtListagem.setRows(5);
        jScrollPane1.setViewportView(edtListagem);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(btnNovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(50, 50, 50)
                        .addComponent(bntEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNome, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblMatricula, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(edtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                        .addGap(50, 50, 50)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                        .addGap(50, 50, 50)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                        .addGap(50, 50, 50))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblIdade)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblSexo)
                                .addGap(16, 16, 16)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(edtSexo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edtIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblAnoIngresso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(edtAnoIngresso, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 759, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(lblIdade)
                    .addComponent(edtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edtIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAnoIngresso)
                    .addComponent(edtAnoIngresso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMatricula)
                    .addComponent(edtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSexo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        this.habilitarCampos(true);
        this.limparCampos();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void bntEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntEditarActionPerformed
        String matriculaEscolhida = JOptionPane.showInputDialog("Informe a Matrícula do aluno que deseja editar: ", "");

        alunoEditando = this.pesquisaAluno(matriculaEscolhida);
        if (alunoEditando == null){
            JOptionPane.showMessageDialog(this, "Não existe um aluno com essa Matrícula!");
        }else{
            this.limparCampos();
            this.habilitarCampos(true);
            this.objetoParaCampos(alunoEditando);
        }
    }//GEN-LAST:event_bntEditarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.limparCampos();
        this.habilitarCampos(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        String cpfEscolhido= JOptionPane.showInputDialog("Informe a Matrícula do Aluno que deseja excluir: ", "");

        Aluno p = this.pesquisaAluno(cpfEscolhido);
        if(p == null){
            JOptionPane.showMessageDialog(this, "Não existe um Aluno com essa Matrícula.");
        }else{
            lista.remove(p);
            JOptionPane.showMessageDialog(this, "Aluno excluído com sucesso!");
        }

        edtListagem.setText(this.imprimirListaAlunos());
    }//GEN-LAST:event_btnExcluirActionPerformed
    
    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if(this.alunoEditando == null){
            Aluno a = new Aluno();
            a = this.camposParaObjeto();
            lista.add(a);
        }else{
            this.lista.remove(this.alunoEditando);
            this.alunoEditando = this.camposParaObjeto();
            this.lista.add(alunoEditando);
        }
        this.limparCampos();
        this.habilitarCampos(false);

        edtListagem.setText(this.imprimirListaAlunos());
        String texto = this.criarListaAlunosCSV();
        this.salvarAlunos(texto);
    }//GEN-LAST:event_btnSalvarActionPerformed
    
    public String imprimirListaAlunos(){
        String listagemTotal = "";
        
        for(int i=0; i<= lista.size()-1; i++){
            listagemTotal += lista.get(i).imprimirParaString();
        }
        return listagemTotal;
    }
    
    public Aluno camposParaObjeto(){
        Aluno a = new Aluno();
        a.setNome(edtNome.getText());
        
        String sexo = edtSexo.getText();
        if(!sexo.isEmpty()){
            a.setSexo(edtSexo.getText().charAt(0));
        }
        
        int i = 0;
        String idade = edtIdade.getText();
        if(!idade.isEmpty()){
            i = Integer.parseInt(edtIdade.getText());
        }
        a.setIdade(i);
        
        a.setMatricula(edtMatricula.getText());
        
        int j = 0;
        String anoIngresso = edtAnoIngresso.getText();
        if(!anoIngresso.isEmpty()){
            j = Integer.parseInt(edtAnoIngresso.getText());
        }
        a.setAnoIngresso(j);
        
        return a;
    }
    
    private void objetoParaCampos(Aluno a) {
        edtNome.setText(a.getNome());
        edtSexo.setText(a.getSexo() + "");
        edtIdade.setText(a.getIdade() + "");
        edtAnoIngresso.setText(a.getAnoIngresso() + "");
        edtMatricula.setText(a.getMatricula() + "");

    }
    
    public Aluno pesquisaAluno(String matricula){
        for(int i=0; i <= lista.size()-1; i++){
            if(lista.get(i).getMatricula().equals(matricula))
                return lista.get(i);
        }
        return null;
    }
    
    public void habilitarCampos(boolean flag){
        edtNome.setEnabled(flag);
        edtSexo.setEnabled(flag);
        edtIdade.setEnabled(flag);
        edtAnoIngresso.setEnabled(flag);
        edtMatricula.setEnabled(flag);
    }
    
    public void limparCampos(){
        edtNome.setText("");
        edtSexo.setText("");
        edtIdade.setText("");
        edtAnoIngresso.setText("");
        edtMatricula.setText("");
    }
    
    private void edtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtNomeActionPerformed

    private void edtIdadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtIdadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtIdadeActionPerformed

    private void edtSexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtSexoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtSexoActionPerformed

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
            java.util.logging.Logger.getLogger(FrAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrAluno().setVisible(true);
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
    private javax.swing.JTextField edtIdade;
    private javax.swing.JTextArea edtListagem;
    private javax.swing.JTextField edtMatricula;
    private javax.swing.JTextField edtNome;
    private javax.swing.JTextField edtSexo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAnoIngresso;
    private javax.swing.JLabel lblIdade;
    private javax.swing.JLabel lblMatricula;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSexo;
    // End of variables declaration//GEN-END:variables
}
