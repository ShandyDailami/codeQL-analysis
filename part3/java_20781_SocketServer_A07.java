import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_20781_SocketServer_A07 {
    private static final int PORT = 9000;

    public static void main(String[] args) {
        System.out.println("Server is starting...");

        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket clientSocket = server.accept();
                System.out.println("Client connected: " + clientSocket.getRemoteSocketAddress());

                // Create a new thread for each client
                Thread thread = new Thread(new ClientHandler(clientSocket));
                thread.start();
            }
        } catch (IOException e) {
            System.out.println("Error in server: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_20781_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Perform authentication here
            // In this example, we're just checking if the client's name matches a fixed string
            if ("test".equals(socket.getRemoteSocketAddress())) {
                System.out.println("Client authenticated");
                // Send a response to the client
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                writer.println("Authenticated successfully");
            } else {
                System.out.println("Authentication failed");
                // Send an error response to the client
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                writer.println("Failed to authenticate");
            }

            socket.close();
        } catch (IOException e) {
            System.out.println("Error handling client: " + e.getMessage());
            e.printStackTrace();
        }
    }
}