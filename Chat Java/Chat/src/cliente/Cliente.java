package cliente;

import static javax.swing.JOptionPane.*;

public class Cliente {

    String nomeCliente;
    
    public void Iniciar() {        
        nomeCliente = showInputDialog(null, "Digite seu nome", " ", PLAIN_MESSAGE);
        
        Chat chat = new Chat(nomeCliente);
        chat.setVisible(true);
        chat.setTitle("Seja bem vindo - " + nomeCliente);
        chat.setResizable(true);
    }
    
    public void setNomeCliente(String nomeCliente){
        this.nomeCliente = nomeCliente;
    }
    
    public String getNomeCliente(){
        return nomeCliente;
    }
}
