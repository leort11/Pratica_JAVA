import java.net.*;
import java.io.*;
import java.util.*;

public class Servidor {
    public static void main(String[] args) throws IOException{
        // --- CRIANDO O SERVIDOR E O SCANNER ---
        ServerSocket serverSocket = new ServerSocket(1234);
        Socket socket = serverSocket.accept();
        Scanner scanner = new Scanner(System.in);

        try {
            // --- ESPERANDO O CLIENTE CONECTAR ---
            System.out.println("Cliente conectou!!");

            // --- RECEBENDO MENSAGEM DO CLIENTE --- 
            InputStreamReader inReader = new InputStreamReader(socket.getInputStream());
            BufferedReader reader = new BufferedReader(inReader);

            // --- MANDANDO A MENSAGEM PARA O CLIENTE ---
            PrintStream out = new PrintStream(socket.getOutputStream());

            // --- DECLARANDO OQUE FOI DIGITADO PELO CLIENTE "x" E OQUE O SERVIDOR VAI ENVIAR "teclado" ---
            String teclado;
            String x;
            while ((x = reader.readLine()) != null) { /* -- LENDO OQUE FOI DIGITADO, E ENVIANDO COM "println()" -- */
                System.out.println("Cliente: " + x);

                // --- PEGANDO OQUE FOI DIGITADO pelo servidor ---
                teclado = scanner.nextLine();

                // out.println("Servidor: " + x);
                out.println(teclado);

            }

          // --- LANÇANDO ERRO SE OCORRER ALGUM ---
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // --- FECHANDO O SERVIDOR E O SCANNER DO TECLADO ---
        serverSocket.close();
        scanner.close();

    }
}