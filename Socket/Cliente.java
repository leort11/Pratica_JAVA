import java.net.*;
import java.util.*;
import java.io.*;

public class Cliente {
    public static void main(String[] args) throws IOException{
        // --- CONECTANDO-SE AO SERVIDOR "localhost" COM A PORTA CERTA "1234" E CRIANDO O SCANNER ---
        Socket socket = new Socket("localhost", 1234);
        Scanner scanner = new Scanner(System.in);

        try {
         
            // --- A THREAD QUE É EXECUTADA TODA VEZ QUE O CLIENTE RECEBE UMA MENSAGEM ---
            // new ClienteThread(s).start(); OU...
            ClienteThread clienteThread = new ClienteThread(socket);
            clienteThread.start();

            // --- MANDANDO A MENSAGEM PARA O SERVIDOR ---
            PrintStream out = new PrintStream(socket.getOutputStream());
            String teclado = scanner.nextLine();
            out.println(teclado);

          // --- LANÇANDO ERRO SE OCORRER ALGUM ---
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        // --- FECHANDO O SCANNER ---
        scanner.close();

    }
}
