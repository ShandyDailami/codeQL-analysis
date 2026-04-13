import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_31995_SocketServer_A03 {

    private static final int DEFAULT_PORT = 1234;
    private static ServerSocket serverSocket;

    public static void main(String[] args) {
        startServer(DEFAULT_PORT);
    }

    private static void startServer(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server is running on port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getRemoteSocketAddress());

                // Start a new thread to handle the client
                new ClientHandler(clientSocket).start();
            }
        } catch (IOException ex) {
            System.out.println("Error accepting client connection: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException ex) {
                    System.out.println("Error closing server socket: " + ex.getMessage());
                    ex.printStackTrace();
                }
            }
        }
    }

    private static class ClientHandler extends Thread {
        private final Socket clientSocket;

        public java_31995_SocketServer_A03(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            // Handle the client here, e.g., read and write data
            // ...
        }
    }
}