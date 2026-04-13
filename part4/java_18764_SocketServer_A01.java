import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_18764_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server started, waiting for client connections...");

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                // Create a new thread for each client
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.err.println("Failed to start server on port " + PORT + ". " + e);
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_18764_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            // Read the first message from the client
            String message = socket.getInputStream().readUTF();
            System.out.println("Received: " + message);

            // Simple echo server
            socket.getOutputStream().writeUTF(message);
            socket.getOutputStream().flush();

            socket.close();
        } catch (IOException e) {
            System.err.println("Failed to handle client " + socket.getRemoteSocketAddress() + ". " + e);
        }
    }
}