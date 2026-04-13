import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_27394_SocketServer_A03 {
    private static final int PORT = 12345;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server is running on port: " + PORT);

            while (true) {
                Socket client = server.accept();
                System.out.println("Client connected: " + client.getRemoteSocketAddress());

                // Create a new thread for each client
                Thread thread = new Thread(new ClientHandler(client));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket client;

    public java_27394_SocketServer_A03(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        // TODO: Implement client handler logic for security-sensitive operations
        // e.g., using SSL/TLS for communication, checking for and sanitizing user input
    }
}