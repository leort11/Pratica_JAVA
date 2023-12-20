import java.io.*;
import java.net.*;

// --- A CLASSE EXTENDE DE "Thread"
public class ClienteThread extends Thread{

    // --- DECLARANDO O SOCKET ---
    private Socket socket;

    // --- MÉTODO CONSTRUTOR ---
    public ClienteThread(Socket socket) {
        this.socket = socket;
    }

    // --- CÓDIGO QUE É RODADO SEMPRE Q FOR CHAMADO A THREAD ---
    @Override
    public void run() {
        try{
            // --- PEGANDO OQUE O SERVIDOR MANDOU PARA O CLIENTE --- 
            InputStreamReader inReader = new InputStreamReader(socket.getInputStream());
            BufferedReader reader = new BufferedReader(inReader);

            // --- ESCREVENDO E ENVIANDO PARA O SERVIDOR ---
            String x;
            while ((x = reader.readLine()) != null) {
                System.out.println("Cliente: " + x);

            }

          // --- LANÇANDO ERRO CASO ACONTEÇA ---
        } catch(Exception e) {
            e.printStackTrace();
        }

    }
}
