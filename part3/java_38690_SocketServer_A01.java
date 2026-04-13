import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_38690_SocketServer_A01 {

    private static final int PORT = 4445;
    private static final int CORE_POOL_SIZE = 2;
    private static final ExecutorService pool = Executors.newFixedThreadPool(CORE_POOL_SIZE);

    public static void main(String[] args) {
        System.out.println("Starting server...");
        startServer();
    }

    private static void startServer() {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Waiting for client connections...");
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Connection accepted from: " + socket.getRemoteSocketAddress());
                // Use asymmetric encryption for client-server communication
                socket.setSoTimeout(1000);
                pool.execute(new SocketHandler(socket));
            }
        } catch (IOException ex) {
            System.out.println("Error accepting client connections: " + ex);
            System.exit(-1);
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    System.out.println("Error closing server socket: " + e);
                }
            }
        }
    }

    static class SocketHandler implements Runnable {
        private Socket socket;

        public java_38690_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Handle the client here. This will involve reading from and writing to the socket
            // For instance, the server might read from the socket to get a message, and then write a response
        }
    }
}