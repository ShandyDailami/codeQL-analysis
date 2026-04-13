import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_31154_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Start a new thread to handle the client communication
                new HandleClientThread(socket).start();
            }
        } catch (IOException e) {
            System.out.println("Failed to listen on port " + PORT);
            System.exit(-1);
        }
    }
}

class HandleClientThread extends Thread {
    private Socket socket;

    public java_31154_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Handle client communication here
        // This is a placeholder, replace with actual client communication code
        try {
            // Receive a message from the client
            byte[] bytes = socket.getInputStream().readAllBytes();
            String message = new String(bytes);

            // Process the message (e.g., for security)
            processMessage(message);

            // Send a response back to the client
            socket.getOutputStream().write("Server received message".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void processMessage(String message) {
        // Placeholder for security-sensitive operation
        // Replace this with your actual code
        // ...
    }
}