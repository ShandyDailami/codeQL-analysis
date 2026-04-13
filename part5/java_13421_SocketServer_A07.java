import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_13421_SocketServer_A07 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server started at port: " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                // Create new thread for each client
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.out.println("Error occurred while running the server: " + e.getMessage());
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_13421_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            // Read the request from the client
            // ... (Implement the authentication and validation here)

            // Send the response back to the client
            // ... (Implement the response here)

            // Close the socket connection
            socket.close();
        } catch (IOException e) {
            System.out.println("Error occurred while handling the client: " + e.getMessage());
        }
    }
}