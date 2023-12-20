import java.net.*;
import java.io.*;


public class Serv {
    public static void main(String[] args) throws IOException{
        ServerSocket serverSocket = new ServerSocket(1111);
        
        try {
            while(true) {
                Socket socket = serverSocket.accept();
                System.out.println("Um cliente se conectou!!!");

                new ClienThread(socket).start();

            }

        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        serverSocket.close();
    }
}