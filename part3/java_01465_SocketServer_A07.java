import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_01465_SocketServer_A07 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server started on port: " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                // Perform authentication
                String clientName = socket.getRemoteSocketAddress().toString();
                if (clientName.equals("127.0.0.1")) {
                    System.out.println("Authentication failed, closing connection.");
                    socket.close();
                    continue;
                }

                // Start new thread for handling client
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.out.println("Error in server: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_01465_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // TODO: Implement client-specific handling here
    }
}