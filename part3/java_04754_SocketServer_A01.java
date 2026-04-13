import java.net.Socket;
import java.net.ServerSocket;
import java.lang.Thread;

public class java_04754_SocketServer_A01 {
    private static final int DEFAULT_PORT = 12345;
    private ServerSocket serverSocket;

    public java_04754_SocketServer_A01() throws Exception {
        // Start the server with a default port
        serverSocket = new ServerSocket(DEFAULT_PORT);
    }

    public void startServer() {
        System.out.println("Server started on port: " + serverSocket.getLocalPort() + ". Waiting for client connections...");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket.getRemoteSocketAddress());

            // Start a new thread for each client
            Thread thread = new Thread(new ClientHandler(clientSocket));
            thread.start();
        }
    }

    // Define a new Thread for each client
    private class ClientHandler implements Runnable {
        private Socket clientSocket;

        public java_04754_SocketServer_A01(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            // TODO: Handle client communication, potentially using a BufferedReader and PrintWriter
            // This is a very basic example and might not be suitable for all use-cases
        }
    }

    public static void main(String[] args) {
        try {
            new SecureSocketServer().startServer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}