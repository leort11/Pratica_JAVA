import java.io.*;
import java.net.*;
import java.util.*;

public class ClienteFerrando {
    public static void main(String[] args) throws IOException{
        try(Socket socket = new Socket("localhost", 1212)) {
            try{
                Scanner scanner = new Scanner(System.in);
                BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintStream saida = new PrintStream(socket.getOutputStream());

                String teclado = "";  
                String resposta = "";
                while (true) {
                    System.out.println("Digite alguma coisa para o servidor retornar! (FIM para encerrar)");
                    teclado = scanner.nextLine();

                    if(teclado.toUpperCase().equals("FIM")) {
                        saida.println(teclado.toUpperCase());
                        break;

                    }
                    
                    saida.println(teclado);
                    saida.flush();

                    resposta = entrada.readLine();
                    System.out.println("Servidor: " + resposta);
                }

                scanner.close();

            } catch(Exception e) {
                System.out.println(e.getMessage());

            }
        }

    }
}
