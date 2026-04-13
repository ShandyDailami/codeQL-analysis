import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_25934_SocketServer_A01 {
    private static final int PORT = 4445;

    public static void main(String[] args) {
        System.out.println("Starting Socket Server");

        try (ServerSocket server = new ServerSocket(PORT)) {
            while (true) {
                System.out.println("Waiting for client connection...");
                Socket socket = server.accept();
                System.out.println("Client connected!");

                // Start a new thread for handling client connection
                new ClientHandler(socket).start();
            }
        } catch (IOException ex) {
            System.out.println("Error accepting client connection: " + ex.getMessage());
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_25934_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Perform security-sensitive operations related to A01_BrokenAccessControl
            // For example, verify the client's identity and ensure they are in a trusted network

            // Read from client
            byte[] buffer = new byte[1024];
            socket.getInputStream().read(buffer);

            // Write response to client
            socket.getOutputStream().write("Hello, client!".getBytes());
        } catch (IOException ex) {
            System.out.println("Error handling client connection: " + ex.getMessage());
        }
    }
}