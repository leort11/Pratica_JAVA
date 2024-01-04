import java.net.*;
import java.io.*;

public class ThreadSantos extends Thread{
    Socket socket = new Socket();

    public ThreadSantos(Socket socket) {
        this.socket = socket;

    }

    @Override
    public void run() {
        try{
            BufferedReader entrada = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            PrintStream saida = new PrintStream(this.socket.getOutputStream());

            String cliente = "";
            while (true) {
                cliente = entrada.readLine();

                if (cliente.toUpperCase().equals("FIM")) {
                    System.out.println("O cliente " + this.socket.getPort() + " desconectou!");
                    break;

                }

                System.out.println("Cliente " + this.socket.getPort() + ": " + cliente);
                saida.println(cliente);
                saida.flush();
            }

        } catch(Exception e) {
            System.out.println(e.getMessage());

        }


    }
}
