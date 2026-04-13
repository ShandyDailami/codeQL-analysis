import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_21737_SocketServer_A03 {

    private static final int DEFAULT_PORT = 8080;

    private int port;
    private ServerSocket serverSocket;

    public java_21737_SocketServer_A03(int port) {
        this.port = port;
        startServer();
    }

    public java_21737_SocketServer_A03() {
        this(DEFAULT_PORT);
    }

    private void startServer() {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started at port " + port);
            acceptClients();
        } catch (IOException e) {
            System.err.println("Error initializing the server at port " + port);
       
        }
    }

    private void acceptClients() {
        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected at port " + clientSocket.getPort());
                new ClientHandler(clientSocket).start();
            } catch (IOException e) {
                System.err.println("Error accepting a client connection at port " + port);
                break;
            }
        }
    }

    private class ClientHandler extends Thread {
        private Socket clientSocket;

        public java_21737_SocketServer_A03(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        public void run() {
            // Handle client communication here
        }
    }

    public static void main(String[] args) {
        new SecureSocketServer();
    }
}