public class TelaAdmin extends javax.swing.JFrame {
    private TelaSorteio tSorteio;

    public TelaAdmin() {
        tSorteio = new TelaSorteio();
        initComponents();
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BancoDados = new javax.swing.JButton();
        Sortear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        BancoDados.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        BancoDados.setText("Banco de dados");
        BancoDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BancoDadosActionPerformed(evt);
            }
        });

        Sortear.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        Sortear.setText("Sorteio Bingo");
        Sortear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SortearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(Sortear, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BancoDados, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BancoDados, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Sortear, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(133, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SortearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SortearActionPerformed
        java.awt.EventQueue.invokeLater(() -> new TelaSorteio().setVisible(true));
    }//GEN-LAST:event_SortearActionPerformed

    private void BancoDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BancoDadosActionPerformed
        //inserir set.visible para o bd
    }//GEN-LAST:event_BancoDadosActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(() -> new TelaAdmin().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BancoDados;
    private javax.swing.JButton Sortear;
    // End of variables declaration//GEN-END:variables
}
