import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_35362_SocketServer_A08 {

    private static final int PORT = 8080;
    private static final String CLIENT_ID = "client_id"; // Replace with your client id

    private static SSLServerSocket sslServerSocket;
    private static ServerSocket serverSocket;
    private static ExecutorService executorService;

    public static void main(String[] args) throws IOException {
        startServer();

        // Listen for incoming connections
        while (true) {
            try {
                Socket socket = sslServerSocket.accept();
                System.out.println("Client " + socket.getInetAddress() + " connected!");

                // Handle the connection in a separate thread
                executorService.execute(new ClientHandler(socket));
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    private static void startServer() throws IOException {
        // Create a pool of threads
        executorService = Executors.newFixedThreadPool(10);

        // Create a SSL server socket
        sslServerSocket = (SSLServerSocket) new SSLServerSocket(PORT, null, InetAddress.getByName("localhost"));

        // Create a server socket (non-SSL)
        serverSocket = new ServerSocket(PORT);
    }

    private static class ClientHandler implements Runnable {
        private final Socket socket;

        public java_35362_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Handle the client connection here
            // ...

            // Close the connection
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}