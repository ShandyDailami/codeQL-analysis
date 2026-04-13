import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_19095_SocketServer_A01 {

    private static final int THREADS = 10;

    public static void main(String[] args) throws IOException {
        // Create an executor with THREADS threads
        ExecutorService executor = Executors.newFixedThreadPool(THREADS);

        // Set up SSLServerSocket
        SSLServerSocket sslServerSocket = (SSLServerSocket) new SSLServerSocket(8080);
        sslServerSocket.setNeedClientAuth(true); // SSL authentication

        System.out.println("Server is waiting for client connections...");

        while (true) {
            final SSLSocket clientSocket = (SSLSocket) sslServerSocket.accept();
            System.out.println("New client connected!");

            // Run the client request in a new thread
            executor.execute(new ClientHandler(clientSocket));
        }
    }

    static class ClientHandler implements Runnable {
        private final SSLSocket socket;

        ClientHandler(SSLSocket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Handle the client request...
        }
    }
}