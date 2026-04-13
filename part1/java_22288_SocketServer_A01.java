import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.net.ssl.*;

public class java_22288_SocketServer_A01 {
    private static final int PORT = 8443;
    private static SSLServerSocket sslServerSocket;
    private static ServerSocket serverSocket;
    private static ExecutorService executor;

    public static void main(String[] args) throws IOException {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        // Setup thread pool for handling multiple requests
        executor = Executors.newFixedThreadPool(5);

        // Create SSLServerSocket and bind it to the port
        sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT);
        sslServerSocket.setNeedClientAuth(true);

        // Create a new server socket
        serverSocket = new ServerSocket();
        serverSocket.bind(serverSocket.getLocalSocketAddress());

        System.out.println("Server is running on port " + PORT);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            // Create a new thread to handle the client connection
            executor.execute(new ClientHandler(clientSocket));
        }
    }

    private static class ClientHandler implements Runnable {
        private final Socket clientSocket;

        public java_22288_SocketServer_A01(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try {
                // Setup SSL connection
                SSLServerSocket serverSocket = (SSLServerSocket) clientSocket.getServerSocket();
                SSLSocket socket = (SSLSocket) serverSocket.accept();
                socket.setNeedClientAuth(true);

                // Perform SSL handshake
                socket.handshake();

                // Now the connection is secure, you can now communicate with the client
                // ...

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    // Close the socket
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}