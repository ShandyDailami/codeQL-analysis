import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_02850_SocketServer_A01 {
    private static final int PORT = 5000;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Create a new thread for handling the client
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.out.println("Failed to establish a connection with the client");
        }
    }
}

class ClientHandler extends Thread {
    private final Socket socket;

    public java_02850_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Write a message to the client
            socket.getOutputStream().write("Hello, client!".getBytes());

            // Read a message from the client
            byte[] buffer = new byte[1024];
            int bytesRead = socket.getInputStream().read(buffer);
            String message = new String(buffer, 0, bytesRead);
            System.out.println("Received message from client: " + message);

            // Close the connection
            socket.close();
        } catch (IOException e) {
            System.out.println("Failed to handle the client connection");
        }
    }
}