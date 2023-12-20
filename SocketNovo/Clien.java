import java.net.*;
import java.io.*;
import java.util.*;

public class Clien {
    public static void main(String[] args) throws IOException{
        Socket socket = new Socket("localhost", 1111);
        Scanner scanner = new Scanner(System.in);
        
        BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter saida = new PrintWriter(socket.getOutputStream());

        String retorno = "";
        String teclado = "";
        while(true) {
            System.out.println("Olá, digite alguma coisa para o servidor ('FIM' para sair): ");
            teclado = scanner.nextLine();

            if(!teclado.equals("")) {
                retorno = entrada.readLine();
                System.out.println("Servidor retornou: " + retorno);

            } else {
                System.out.println("Digite alguma coisa");

            }

        }

    }
}
