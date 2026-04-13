import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_09931_SocketServer_A03 {
    private static final int PORT = 5000;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server started. Waiting for connections...");

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                // Start a new thread for each client
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.err.println("Failed to bind port " + PORT + ": " + e.getMessage());
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_09931_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            // Receive message from client
            byte[] buffer = new byte[1024];
            socket.getInputStream().read(buffer);
            String message = new String(buffer, 0, socket.getInputStream().available());
            System.out.println("Received: " + message);

            // Send a response
            String response = "Hello, client!";
            socket.getOutputStream().write(response.getBytes());
        } catch (IOException e) {
            System.err.println("Failed to handle client: " + e.getMessage());
        }
    }
}