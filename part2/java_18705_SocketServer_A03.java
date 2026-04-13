import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_18705_SocketServer_A03 {
    private static final int PORT = 1234;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server started on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                // Handling the client connection in a separate thread
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.out.println("Failed to start server: " + e.getMessage());
        }
    }
}

class ClientHandler extends Thread {
    private final Socket socket;

    public java_18705_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Receive a message from the client
            byte[] buffer = new byte[1024];
            int bytesRead = socket.getInputStream().read(buffer);
            String message = new String(buffer, 0, bytesRead);

            // Process the message (e.g. log it or do something else)
            System.out.println("Received: " + message);

            // Send a response back to the client
            String response = "Hello, client!";
            byte[] responseBytes = response.getBytes();
            socket.getOutputStream().write(responseBytes);
        } catch (IOException e) {
            System.out.println("Failed to handle client: " + e.getMessage());
        }
    }
}