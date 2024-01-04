import java.net.*;
import java.io.*;

public class ServidorDaSilva {
    public static void main(String[] args) throws IOException{
        System.out.println("Servidor ligado!!!");
        try (ServerSocket serverSocket = new ServerSocket(1212)) {
            while (true) {
                try {
                    Socket socket = serverSocket.accept();
                    System.out.println("Cliente " + socket.getPort() + " conectou");

                    new ThreadSantos(socket).start();

               } catch (Exception e) {
                    System.out.println(e.getMessage());

               }
      }
        }

        
    }
}
