import java.net.*;

public class ThreadSantos extends Thread{
    Socket socket = new Socket();

    public ThreadSantos(Socket socket) {
        this.socket = socket;

    }

    @Override
    public void run() {
        
    }
}
