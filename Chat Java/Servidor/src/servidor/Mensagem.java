package servidor;

import com.sun.xml.internal.ws.client.AsyncResponseImpl;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;
import java.util.ArrayList;
import java.io.PrintStream;
public class Mensagem {

    //Declaração
    private final Socket socket;
    private final ArrayList<PrintStream> nomeCliente;
    
    //Construtor
    public Mensagem(Socket socket, ArrayList<PrintStream> nomeCliente) {
        this.socket = socket;
        this.nomeCliente = nomeCliente;
        Thread();
    }

    private void Thread() {

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {                
                String mensagem;
                try {
                    InputStreamReader isr = new InputStreamReader(socket.getInputStream());
                    BufferedReader br = new BufferedReader(isr);
                    while ((mensagem = br.readLine()) != null) {          
                        enviarMensagem(mensagem);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                
            }
        });
        t.start();
    }

    private void enviarMensagem(String mensagem) {
        //Envia mensagens para todos os clientes conecatados ao servidor
        for (int count = 0; count < nomeCliente.size(); count++) {
            nomeCliente.get(count).println(mensagem);
            nomeCliente.get(count).flush();
        }
    }
}
