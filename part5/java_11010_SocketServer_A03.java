import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_11010_SocketServer_A03 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started at port: " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("New client connected: " + socket.getRemoteSocketAddress());

            // Create new threads for each client
            Thread clientThread = new Thread(new ClientHandler(socket));
            clientThread.start();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_11010_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // In a real-world application, you would use a thread-safe way of writing to the client,
        // and you would use a secure way of reading from the client (e.g., use a BufferedReader).
        // This is a simplified example to demonstrate the concept.
        try {
            // Read from client
            byte[] buffer = new byte[1024];
            socket.getInputStream().read(buffer);
            String message = new String(buffer);

            // Handle message (e.g., remove injection attacks)
            message = sanitizeInput(message);

            // Write back to client
            socket.getOutputStream().write(message.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String sanitizeInput(String input) {
        // This is a placeholder for a real-world application.
        // The actual implementation of this method depends on the specific security requirements.
        // In a real-world application, you would use a library or framework that can automatically sanitize user-provided input.
        // For example, the Java Sanitizer library can automatically sanitize user-provided input.
        return input;
    }
}