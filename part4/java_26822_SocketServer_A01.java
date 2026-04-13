import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_26822_SocketServer_A01 {

    private static final int SERVER_PORT = 9000;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {
            System.out.println("Server is listening on port " + SERVER_PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getRemoteSocketAddress());

                // Simulate a security-sensitive operation related to Broken Access Control
                // Here we are just checking if the client can connect, if not it disconnects
                if (!clientSocket.isConnected()) {
                    System.out.println("Client Disconnected: " + clientSocket.getRemoteSocketAddress());
                    continue;
                }

                // Handle the client connection
                new ClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_26822_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Handle the client connection
    }
}