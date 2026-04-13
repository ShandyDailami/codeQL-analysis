import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_18406_SocketServer_A07 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server started, waiting for client connections...");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.err.println("Failed to start server: " + e.getMessage());
        }
    }
}

class ClientHandler extends Thread {
    private final Socket socket;

    public java_18406_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Here you can add your business logic to handle client requests
            // For example, you can read a message from the client and print it
            // Then you can send a response back to the client

            // For simplicity, we'll just read and print the message
            byte[] buffer = new byte[1024];
            int bytesRead = socket.getInputStream().read(buffer);
            if (bytesRead < 0) {
                System.out.println("Client disconnected.");
            } else {
                String message = new String(buffer, 0, bytesRead);
                System.out.println("Received: " + message);

                // Send a response back to the client
                String response = "Hello, client!";
                socket.getOutputStream().write(response.getBytes());
            }
        } catch (IOException e) {
            System.err.println("Failed to handle client: " + e.getMessage());
        }
    }
}