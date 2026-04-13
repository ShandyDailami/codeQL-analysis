import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_03218_SocketServer_A07 {
    private static final int PORT = 5000;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Create a new thread for each client
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.out.println("Failed to bind port " + PORT + ": " + e.getMessage());
        }
    }
}

class ClientHandler extends Thread {
    private final Socket socket;

    public java_03218_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Receive the message from the client
            byte[] buffer = new byte[1024];
            socket.getInputStream().read(buffer);
            String message = new String(buffer, 0, buffer.length);
            System.out.println("Received message from client: " + message);

            // Send a response back to the client
            String response = "Hello, Client!";
            socket.getOutputStream().write(response.getBytes());
        } catch (IOException e) {
            System.out.println("Failed to handle client connection: " + e.getMessage());
        }
    }
}