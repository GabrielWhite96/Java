package gui;

import classes.Professor;
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

public class FrProfessor extends javax.swing.JFrame {
    
    Professor profEditando;
    List<Professor> lista;
    
    public FrProfessor() {
        lista = new ArrayList<>();
        this.profEditando = null;
        initComponents();
        this.habilitarCampos(false);
        this.limparCampos();
        this.loadProfessores();
    }
    
    public void habilitarCampos(boolean flag){
        edtNome.setEnabled(flag);
        edtSexo.setEnabled(flag);
        edtIdade.setEnabled(flag);
        edtCpf.setEnabled(flag);
    }
    
    public void limparCampos(){
        edtNome.setText("");
        edtSexo.setText("");
        edtIdade.setText("");
        edtCpf.setText("");
    }
    
    public String criarListaProfessoresCSV(){
        String texto = "";
        Professor a = new Professor();
        texto = a.cabecalho();
        
        for(int i=0; i <= this.lista.size()-1; i++){
            Professor p = this.lista.get(i);
            texto = texto + p.atributoToCSV();
        }
        return texto;
    }
    
    public void salvarProfessores(String texto){
        FileWriter arq = null;
        try {
            arq = new FileWriter("ListaProfessores.csv");
            PrintWriter gravaArq = new PrintWriter(arq);
            gravaArq.print(texto);
            arq.close();
        } catch (IOException ex) {
            Logger.getLogger(FrProfessor.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                arq.close();
            } catch (IOException ex) {
                Logger.getLogger(FrProfessor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void loadProfessores(){
        FileReader f = null;
        try {
            f = new FileReader("ListaProfessores.csv");
            Scanner arquivoLido = new Scanner(f);
            arquivoLido.useDelimiter("\n");
            this.lista = new ArrayList<>();
            String linhaLida = arquivoLido.next();
            while(arquivoLido.hasNext()){
                linhaLida = arquivoLido.next();
                
                Professor p = new Professor();
                p.CSVToAtributo(linhaLida);
                this.lista.add(p);
            }   edtListagem.setText(imprimirListaProfessores());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrProfessor.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                f.close();
            } catch (IOException ex) {
                Logger.getLogger(FrProfessor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnNovo = new javax.swing.JButton();
        bntEditar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        lblNome = new javax.swing.JLabel();
        edtNome = new javax.swing.JTextField();
        lblIdade = new javax.swing.JLabel();
        lblSexo = new javax.swing.JLabel();
        edtSexo = new javax.swing.JTextField();
        lblCpf = new javax.swing.JLabel();
        edtCpf = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        edtListagem = new javax.swing.JTextArea();
        edtIdade = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CADASTRO DO PROFESSOR");

        btnNovo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/novo.png"))); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

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

        lblIdade.setText("Idade:");

        lblSexo.setText("Sexo:");

        edtSexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtSexoActionPerformed(evt);
            }
        });

        lblCpf.setText("Cpf:");

        edtListagem.setColumns(20);
        edtListagem.setRows(5);
        jScrollPane1.setViewportView(edtListagem);

        edtIdade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtIdadeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(btnNovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(30, 30, 30)
                        .addComponent(bntEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(30, 30, 30)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(30, 30, 30)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(30, 30, 30)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(30, 30, 30))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNome)
                            .addComponent(lblCpf))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(edtNome, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                            .addComponent(edtCpf))
                        .addGap(169, 169, 169)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblIdade)
                            .addComponent(lblSexo))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(edtSexo)
                            .addComponent(edtIdade))
                        .addGap(28, 28, 28))))
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 729, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(edtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSexo)
                    .addComponent(edtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(edtIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblIdade))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(edtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblCpf)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        this.habilitarCampos(true);
        this.limparCampos();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void bntEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntEditarActionPerformed
        String cpfEscolhido= JOptionPane.showInputDialog("Informe o CPF do professor que deseja editar: ", "");
        
        profEditando = this.pesquisaProfessor(cpfEscolhido);
        if (profEditando == null){
            JOptionPane.showMessageDialog(this, "Não existe um professor com esse CPF");
        }else{
            this.limparCampos();
            this.habilitarCampos(true);
            this.objetoParaCampos(profEditando);
        }
    }//GEN-LAST:event_bntEditarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.limparCampos();    
        this.habilitarCampos(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        String cpfEscolhido= JOptionPane.showInputDialog("Informe o CPF do professor que deseja excluir: ", "");
        
        Professor p = this.pesquisaProfessor(cpfEscolhido);
        if(p == null){
            JOptionPane.showMessageDialog(this, "Não existe um Professor com esse cpf.");
        }else{
            lista.remove(p);
            JOptionPane.showMessageDialog(this, "professor excluído com sucesso!");
        }
        
        edtListagem.setText(this.imprimirListaProfessores());
    }//GEN-LAST:event_btnExcluirActionPerformed
    
    public Professor pesquisaProfessor(String cpf){
        for(int i=0; i<= lista.size()-1; i++){
            if(lista.get(i).getCpf().equals(cpf))
                return lista.get(i);
        }
        return null;
    }
    
    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if(this.profEditando == null){
            Professor p = new Professor();
            p = this.camposParaObjeto();
            lista.add(p);  
        }else{
            this.lista.remove(this.profEditando);
            this.profEditando = this.camposParaObjeto();
            this.lista.add(profEditando);         
        }
        this.limparCampos();
        this.habilitarCampos(false);
        
        edtListagem.setText(this.imprimirListaProfessores());
        String texto = this.criarListaProfessoresCSV();
        this.salvarProfessores(texto);
    }//GEN-LAST:event_btnSalvarActionPerformed
    
    private void objetoParaCampos(Professor p) {
        edtNome.setText(p.getNome());
        edtSexo.setText(p.getSexo() + "");
        edtIdade.setText(p.getIdade() + "");
        edtCpf.setText(p.getCpf());
    }
        
    public String imprimirListaProfessores(){
        String listagemTotal = "";
        
        for(int i=0; i<= lista.size()-1; i++){
            listagemTotal += lista.get(i).imprimirParaString();
        }
        return listagemTotal;
    }
    
    private void edtSexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtSexoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtSexoActionPerformed

    private void edtIdadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtIdadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtIdadeActionPerformed
    
    public Professor camposParaObjeto(){
        Professor p = new Professor();
        p.setNome(edtNome.getText());
        
        String  sexo = edtSexo.getText();
        if(!sexo.isEmpty()){
            p.setSexo(edtSexo.getText().charAt(0));
        }
        
        int a = 0;
        String idade = edtIdade.getText();
        if(!idade.isEmpty()){
            a = Integer.parseInt(edtIdade.getText());
        }
        p.setIdade(a);
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
            java.util.logging.Logger.getLogger(FrProfessor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrProfessor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrProfessor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrProfessor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrProfessor().setVisible(true);
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
    private javax.swing.JTextField edtIdade;
    private javax.swing.JTextArea edtListagem;
    private javax.swing.JTextField edtNome;
    private javax.swing.JTextField edtSexo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblIdade;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSexo;
    // End of variables declaration//GEN-END:variables
}