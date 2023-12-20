import java.net.*;
import java.io.*;

public class ClienThread extends Thread{
    Socket socket;

    public ClienThread(Socket socket) {
        this.socket = socket;
        
    }

    @Override
    public void run() {
        try {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            PrintWriter saida = new PrintWriter(this.socket.getOutputStream());

            String digitou = "";
            while(true) {
                digitou = entrada.readLine().toUpperCase();
                System.out.println("Cliente: " + digitou);

                if(digitou.equals("FIM")) {
                    System.out.println("Cliente saiu!!" + socket);
                    break;

                }

                saida.println(digitou);

            }

        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            this.socket.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    } 
}
