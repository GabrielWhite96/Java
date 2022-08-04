package gui;

import classes.Teacher;
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

public class FrTeacher extends javax.swing.JFrame {
    
    Teacher profEditando;
    List<Teacher> lista;
    
    public FrTeacher() {
        lista = new ArrayList<>();
        this.profEditando = null;
        initComponents();
        this.habilitarCampos(false);
        this.limparCampos();
        this.loadTeacher();
    }
    
    public void habilitarCampos(boolean flag){
        edtNome.setEnabled(flag);
        edtsex.setEnabled(flag);
        edtage.setEnabled(flag);
        edtCpf.setEnabled(flag);
    }
    
    public void limparCampos(){
        edtNome.setText("");
        edtsex.setText("");
        edtage.setText("");
        edtCpf.setText("");
    }
    
    public String createTeacherListCSV(){
        String texto = "";
        Teacher a = new Teacher();
        texto = a.cabecalho();
        
        for(int i=0; i <= this.lista.size()-1; i++){
            Teacher p = this.lista.get(i);
            texto = texto + p.atributoToCSV();
        }
        return texto;
    }
    
    public void saveTeachers(String texto){
        FileWriter arq = null;
        try {
            arq = new FileWriter("ListaTeachers.csv");
            PrintWriter gravaArq = new PrintWriter(arq);
            gravaArq.print(texto);
            arq.close();
        } catch (IOException ex) {
            Logger.getLogger(FrTeacher.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                arq.close();
            } catch (IOException ex) {
                Logger.getLogger(FrTeacher.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void loadTeacher(){
        FileReader f = null;
        try {
            f = new FileReader("ListaTeachers.csv");
            Scanner arquivoLido = new Scanner(f);
            arquivoLido.useDelimiter("\n");
            this.lista = new ArrayList<>();
            String linhaLida = arquivoLido.next();
            while(arquivoLido.hasNext()){
                linhaLida = arquivoLido.next();
                
                Teacher p = new Teacher();
                p.CSVToAtributo(linhaLida);
                this.lista.add(p);
            }   
            edtListagem.setText(printTeacherList());
            arquivoLido.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrTeacher.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                f.close();
            } catch (IOException ex) {
                Logger.getLogger(FrTeacher.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblsex = new javax.swing.JLabel();
        edtsex = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        lblCpf = new javax.swing.JLabel();
        btnNovo = new javax.swing.JButton();
        edtCpf = new javax.swing.JTextField();
        bntEditar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        edtListagem = new javax.swing.JTextArea();
        btnCancelar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        edtage = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        lblNome = new javax.swing.JLabel();
        edtNome = new javax.swing.JTextField();
        lblage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(70, 70, 70));

        lblsex.setForeground(new java.awt.Color(255, 255, 255));
        lblsex.setText("sex:");

        edtsex.setBackground(new java.awt.Color(60, 60, 60));
        edtsex.setForeground(new java.awt.Color(255, 255, 255));
        edtsex.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 30, 30)));
        edtsex.setCaretColor(new java.awt.Color(255, 255, 255));
        edtsex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtsexActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(60, 60, 60));
        jLabel1.setFont(new java.awt.Font("Arcane Nine", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CADASTRO DO PROFESSOR");

        lblCpf.setForeground(new java.awt.Color(255, 255, 255));
        lblCpf.setText("Cpf:");

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

        edtCpf.setBackground(new java.awt.Color(60, 60, 60));
        edtCpf.setForeground(new java.awt.Color(255, 255, 255));
        edtCpf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 30, 30)));
        edtCpf.setCaretColor(new java.awt.Color(255, 255, 255));

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

        edtListagem.setBackground(new java.awt.Color(60, 60, 60));
        edtListagem.setColumns(20);
        edtListagem.setForeground(new java.awt.Color(255, 255, 255));
        edtListagem.setRows(5);
        edtListagem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 30, 30)));
        jScrollPane1.setViewportView(edtListagem);

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

        edtage.setBackground(new java.awt.Color(60, 60, 60));
        edtage.setForeground(new java.awt.Color(255, 255, 255));
        edtage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 30, 30)));
        edtage.setCaretColor(new java.awt.Color(255, 255, 255));
        edtage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtageActionPerformed(evt);
            }
        });

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
        edtNome.setSelectionColor(new java.awt.Color(255, 51, 204));

        lblage.setForeground(new java.awt.Color(255, 255, 255));
        lblage.setText("age:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                    .addComponent(btnNovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bntEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblNome)
                        .addGap(214, 214, 214)
                        .addComponent(lblsex))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(edtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCpf)
                            .addComponent(edtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblage)
                            .addComponent(edtage)
                            .addComponent(edtsex, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1))
                .addGap(0, 49, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNome)
                            .addComponent(lblsex))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(edtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edtsex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(btnNovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblage)
                            .addComponent(lblCpf))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(edtage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(bntEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        String cpfEscolhido= JOptionPane.showInputDialog("Informe o CPF do professor que deseja editar: ", "");
        
        profEditando = this.searchTeacher(cpfEscolhido);
        if (profEditando == null){
            JOptionPane.showMessageDialog(this, "Não existe um professor com esse CPF");
        }else{
            this.limparCampos();
            this.habilitarCampos(true);
            this.objectToField(profEditando);
        }
    }//GEN-LAST:event_bntEditarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.limparCampos();    
        this.habilitarCampos(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        String cpfEscolhido= JOptionPane.showInputDialog("Informe o CPF do professor que deseja excluir: ", "");
        
        Teacher p = this.searchTeacher(cpfEscolhido);
        if(p == null){
            JOptionPane.showMessageDialog(this, "Não existe um Professor com esse cpf.");
        }else{
            lista.remove(p);
            JOptionPane.showMessageDialog(this, "professor excluído com sucesso!");
        }
        
        edtListagem.setText(this.printTeacherList());
    }//GEN-LAST:event_btnExcluirActionPerformed
    
    public Teacher searchTeacher(String cpf){
        for(int i=0; i<= lista.size()-1; i++){
            if(lista.get(i).getCpf().equals(cpf))
                return lista.get(i);
        }
        return null;
    }
    
    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if(this.profEditando == null){
            Teacher p = new Teacher();
            p = this.fieldToObject();
            lista.add(p);  
        }else{
            this.lista.remove(this.profEditando);
            this.profEditando = this.fieldToObject();
            this.lista.add(profEditando);         
        }
        this.limparCampos();
        this.habilitarCampos(false);
        
        edtListagem.setText(this.printTeacherList());
        String texto = this.createTeacherListCSV();
        this.saveTeachers(texto);
    }//GEN-LAST:event_btnSalvarActionPerformed
    
    private void objectToField(Teacher p) {
        edtNome.setText(p.getName());
        edtsex.setText(p.getSex() + "");
        edtage.setText(p.getAge() + "");
        edtCpf.setText(p.getCpf());
    }
        
    public String printTeacherList(){
        String listagemTotal = "";
        
        for(int i=0; i<= lista.size()-1; i++){
            listagemTotal += lista.get(i).toString();
        }
        return listagemTotal;
    }
    
    private void edtsexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtsexActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtsexActionPerformed

    private void edtageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtageActionPerformed
    
    public Teacher fieldToObject(){
        Teacher p = new Teacher();
        p.setName(edtNome.getText());
        
        String  sex = edtsex.getText();
        if(!sex.isEmpty()){
            p.setSex(edtsex.getText().charAt(0));
        }
        
        int a = 0;
        String age = edtage.getText();
        if(!age.isEmpty()){
            a = Integer.parseInt(edtage.getText());
        }
        p.setAge(a);
        p.setCpf(edtCpf.getText());
        
        return p;
    }
    
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
            java.util.logging.Logger.getLogger(FrTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrTeacher().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntEditar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JTextField edtCpf;
    private javax.swing.JTextField edtage;
    private javax.swing.JTextArea edtListagem;
    private javax.swing.JTextField edtNome;
    private javax.swing.JTextField edtsex;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblage;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblsex;
    // End of variables declaration//GEN-END:variables
}