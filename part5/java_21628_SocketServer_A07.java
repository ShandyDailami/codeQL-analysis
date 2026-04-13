import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_21628_SocketServer_A07 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server started, waiting for client connections...");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                // Start a new thread for each client
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.out.println("Failed to bind port " + PORT + ": " + e.getMessage());
            System.exit(-1);
        }
    }
}

class ClientHandler extends Thread {
    private final Socket socket;

    public java_21628_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // TODO: Implement authentication process
        // This is a simplistic example and doesn't include any security-sensitive operations
        // Replace it with your own authentication process

        try {
            // Read the username from the client
            socket.getInputStream().read();

            // TODO: Send a response back to the client
            socket.getOutputStream().write("Hello, Client!".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}