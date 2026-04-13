import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

public class java_01102_SocketServer_A08 {

    private static final int PORT = 8888;

    public static void main(String[] args) throws IOException {
        // Create a pool of threads for handling multiple connections
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        // Create a SSL Server Socket
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT);

        System.out.println("Server started. Listening for incoming connections on port " + PORT);

        // Accept connections
        while (true) {
            Socket socket = sslServerSocket.accept();
            System.out.println("New client connected");
            // Handles the client connection in a separate thread
            executorService.execute(new ClientHandler(socket));
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket socket;

        public java_01102_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Handle client connection and data here...
        }
    }
}