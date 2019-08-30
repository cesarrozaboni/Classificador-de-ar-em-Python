package servidor;

import java.io.IOException;
import java.io.PrintStream;
import java.net.*; // API Socket
import java.util.ArrayList;

public class Servidor
{
    public static void main(String[] args)
    {
        //Adiciona clientes para conversas em grupo
        ArrayList<PrintStream> nomeCliente = new ArrayList<>();
        try
        {
            //Cria porta de conexão com o servidor (5000)
            ServerSocket server = new ServerSocket(5000);
            Socket socket;
            while (true)
            {
                // Aceita novas conexões de clientes
                socket = server.accept();
                //Adiciona os clientes para troca das mensagens em grupo 
                nomeCliente.add(new PrintStream(socket.getOutputStream()));
                //Envia as mensagens para os clientes.
                Mensagem mensagem = new Mensagem(socket, nomeCliente);
                System.out.println(mensagem);
            }
        } 
        catch (IOException e)
        {
            //Metodo para mostrar erros com o servidor
            e.printStackTrace();
        }
    }
}
