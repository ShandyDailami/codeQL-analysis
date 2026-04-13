import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

public class java_03587_SocketServer_A08 {
    private final static int PORT = 8888;
    private final static int THREADS = 10;

    public static void main(String[] args) throws IOException {
        ExecutorService executor = Executors.newFixedThreadPool(THREADS);

        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT);

        sslServerSocket.setNeedClientAuthentication(true);

        while (true) {
            Socket socket = sslServerSocket.accept();
            System.out.println("New client connected");

            ServerWorker worker = new ServerWorker(socket);
            executor.submit(worker);
        }
    }
}

class ServerWorker implements Runnable {
    private Socket socket;

    public java_03587_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Handle the client connection, read, and write operations here
    }
}