package cliente;

import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.*; // API sockets
import javax.swing.JOptionPane;

public class Chat extends javax.swing.JFrame {
    private String nomeCliente;
    private Socket socket;
    private BufferedReader br;
    private InputStreamReader isr;
    
    //construtor
    public Chat(String nomeCliente) {
        initComponents();
        this.nomeCliente = nomeCliente;
        try{
            //Porta de conexao com o servidor
            socket = new Socket("127.0.0.1", 5000);
            Thread();
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Sem conexão com o servidor", "", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }       
    }

    // Monitora as mensagem recebidas
    private void Thread() {
        Thread t = new Thread(new Runnable() {
            String mensagem;
            @Override
            public void run() {
                try {
                     //Recebe mensagens do servidor (getinputStream)
                     isr = new InputStreamReader(socket.getInputStream());
                     //Armazena mensagens em memoria temporariamente
                     br = new BufferedReader(isr);
                     while ((mensagem = br.readLine()) != null){
                        //Exibe a mensagem na tela para o usuario
                        txtmsgrecebida.setText(txtmsgrecebida.getText() + mensagem + "\n");
                    }
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Erro na conexão com o servidor", "", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        t.start();
    }
    
     public void Sair() {
        //Função para encerrar o programa
        try {
            socket.close();
            System.exit(0);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.toString(), "", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtmsgrecebida = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtmsgenviada = new javax.swing.JTextArea();
        btenviar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 204, 51));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        txtmsgrecebida.setEditable(false);
        txtmsgrecebida.setFocusable(false);
        txtmsgrecebida.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(txtmsgrecebida);

        txtmsgenviada.setColumns(20);
        txtmsgenviada.setRows(1);
        txtmsgenviada.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtmsgenviadaKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(txtmsgenviada);

        btenviar.setText("ENVIAR");
        btenviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btenviarActionPerformed(evt);
            }
        });

        btnLimpar.setText("LIMPAR");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btenviar)
                            .addComponent(btnLimpar))))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btenviar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimpar)))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        btenviar.getAccessibleContext().setAccessibleParent(btenviar);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btenviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btenviarActionPerformed
        String mensagem = (nomeCliente + " disse: ");
        try {
            //metodo socket para enviar a mensagem
            PrintStream ps = new PrintStream(socket.getOutputStream());
            //Recupera o texto do campo
            mensagem += txtmsgenviada.getText();
            //Envia mensagem
            ps.println(mensagem);
            //Limpar a memória
            ps.flush(); 
            //Limpa a mensagem da caixa de texto
            txtmsgenviada.setText("");
            txtmsgenviada.remove(0);
            //Direciona o cursor para o campo da mensagem enviada
            txtmsgenviada.requestFocus();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Não foi possivel enviar a mensagem", "", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btenviarActionPerformed

    private void txtmsgenviadaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmsgenviadaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btenviarActionPerformed(null);
        }
    }//GEN-LAST:event_txtmsgenviadaKeyPressed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
       txtmsgrecebida.setText(System.clearProperty(nomeCliente));
    }//GEN-LAST:event_btnLimparActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btenviar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txtmsgenviada;
    public javax.swing.JTextArea txtmsgrecebida;
    // End of variables declaration//GEN-END:variables
}
