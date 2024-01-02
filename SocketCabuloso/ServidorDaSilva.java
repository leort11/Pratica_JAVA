import java.net.*;
import java.io.*;

public class ServidorDaSilva {
    public static void main(String[] args) throws IOException{
        try (ServerSocket serverSocket = new ServerSocket(1212)) {
            while (true) {
                try {
                    Socket socket = serverSocket.accept();

                    new ThreadSantos(socket).start();

               } catch (Exception e) {
                    System.out.println(e.getMessage());

               }
      }
        }

        
    }
}
