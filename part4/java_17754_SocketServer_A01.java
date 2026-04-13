import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_17754_SocketServer_A01 {

    private int port;
    private ServerSocket serverSocket;

    public java_17754_SocketServer_A01(int port) {
        this.port = port;
    }

    public void startServer() {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started on port: " + port);
            while (true) {
                handleClient(serverSocket.accept());
            }
        } catch (IOException e) {
            System.out.println("Server failed to start. Exiting.");
            e.printStackTrace();
            stopServer();
        }
    }

    private void handleClient(Socket clientSocket) {
        System.out.println("A new client has connected.");
        new ClientHandler(clientSocket).start();
    }

    private void stopServer() {
        try {
            serverSocket.close();
        } catch (IOException e) {
            System.out.println("Failed to close server socket. Exiting.");
            e.printStackTrace();
        }
        System.out.println("Server has stopped.");
    }

    public static void main(String[] args) {
        new SecureServer(1234).startServer();
    }

    private class ClientHandler extends Thread {
        private Socket clientSocket;

        public java_17754_SocketServer_A01(Socket socket) {
            this.clientSocket = socket;
        }

        public void run() {
            // Handle client's request here.
            // For security-sensitive operations, follow this template:

            // Create a new input stream from the client socket.
            // Read data from the client socket.
            // Check if the data is secure (e.g., check if it's properly encrypted).
            // If the data is secure, process it.
            // If the data is not secure, deny access.

            // Continue handling client's request until it's finished.
        }
    }
}