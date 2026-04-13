import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_12278_SocketServer_A03 {
    private static final int PORT = 12345;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server started. Waiting for connections...");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                // Create a new thread for each client
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.out.println("Server failed to start: " + e.getMessage());
        }
    }
}

class ClientHandler extends Thread {
    private final Socket socket;

    public java_12278_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Here you can perform security-sensitive operations related to A03_Injection
        // For simplicity, this example just closes the connection
        try {
            socket.close();
        } catch (IOException e) {
            System.out.println("Failed to close connection: " + e.getMessage());
        }
    }
}