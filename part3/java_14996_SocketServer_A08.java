import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_14996_SocketServer_A08 {
    private static final int DEFAULT_PORT = 8080;
    private static final int MAX_POOL_SIZE = 10;

    private final ExecutorService executor;
    private ServerSocket serverSocket;

    public java_14996_SocketServer_A08() throws IOException {
        executor = Executors.newFixedThreadPool(MAX_POOL_SIZE);
        serverSocket = new ServerSocket(DEFAULT_PORT, 0, InetAddress.getByName("localhost"));
    }

    public void start() throws IOException {
        System.out.println("Server started on port " + serverSocket.getLocalPort() + ".");
        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Accepted new connection from " + clientSocket.getRemoteSocketAddress());
            executor.execute(new ClientHandler(clientSocket));
        }
    }

    public void stop() throws IOException {
        serverSocket.close();
        executor.shutdown();
    }

    private class ClientHandler implements Runnable {
        private final Socket clientSocket;

        public java_14996_SocketServer_A08(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            // Here you can implement your client-side code for handling the client connection.
            // For now, we're only printing the client's address and closing the connection.
            System.out.println("Handling client connection from " + clientSocket.getRemoteSocketAddress());
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        SecureSocketServer server = new SecureSocketServer();
        server.start();
    }
}