package cliente;

import javax.swing.JOptionPane;

public class Principal extends javax.swing.JFrame {
    public Principal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        miitens = new javax.swing.JMenu();
        michat = new javax.swing.JMenuItem();
        miajuda = new javax.swing.JMenuItem();
        micreditos = new javax.swing.JMenuItem();
        miopcoes = new javax.swing.JMenu();
        misair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setName(""); // NOI18N

        jLabel1.setText("Divirta Com nosso Chat!!!");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(205, Short.MAX_VALUE))
        );

        miitens.setText("Menu");

        michat.setText("Novo Chat");
        michat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                michatActionPerformed(evt);
            }
        });
        miitens.add(michat);

        miajuda.setText("Ajuda");
        miajuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miajudaActionPerformed(evt);
            }
        });
        miitens.add(miajuda);

        micreditos.setText("Creditos");
        micreditos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                micreditosActionPerformed(evt);
            }
        });
        miitens.add(micreditos);

        jMenuBar1.add(miitens);

        miopcoes.setText("Opções");

        misair.setText("Sair");
        misair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                misairActionPerformed(evt);
            }
        });
        miopcoes.add(misair);

        jMenuBar1.add(miopcoes);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void michatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_michatActionPerformed
        Cliente cliente = new Cliente();
        cliente.Iniciar();
        System.out.println("Novo cliente:" + cliente.nomeCliente);
    }//GEN-LAST:event_michatActionPerformed

    private void miajudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miajudaActionPerformed
        JOptionPane.showMessageDialog(null, "Para usar o chat:\n1º Iniciar o servidor"
                + "\n2º Adicionar usuario!"
                + "\n   Esse chat é destinado para conversas em grupo!"
                + "\n   Divirta-se!!!!");
    }//GEN-LAST:event_miajudaActionPerformed

    private void micreditosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_micreditosActionPerformed
        JOptionPane.showMessageDialog(null, "Este trabalho foi Desenvolvido por\n"
        + " Cesar Augusto Rozaboni");
    }//GEN-LAST:event_micreditosActionPerformed

    private void misairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_misairActionPerformed
         System.exit(0);
    }//GEN-LAST:event_misairActionPerformed
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new Principal().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuItem miajuda;
    private javax.swing.JMenuItem michat;
    private javax.swing.JMenuItem micreditos;
    private javax.swing.JMenu miitens;
    private javax.swing.JMenu miopcoes;
    private javax.swing.JMenuItem misair;
    // End of variables declaration//GEN-END:variables
}
