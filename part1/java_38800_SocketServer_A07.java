import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_38800_SocketServer_A07 {

    private final int port;
    private ServerSocket serverSocket;

    public java_38800_SocketServer_A07(int port) {
        this.port = port;
        initializeServerSocket();
    }

    private void initializeServerSocket() {
        try {
            serverSocket = new ServerSocket(port);
            serverSocket.setReuseAddress(true);
            System.out.println("Server is listening on port " + port);
        } catch (IOException e) {
            System.out.println("Failed to initialize server on port " + port);
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void startServer() {
        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Accepted new connection from " + clientSocket.getRemoteSocketAddress());

                // Here is where you would handle authentication related operations
                // For example, you can use SSL/TLS to ensure the client is who they claim to be
                // If the client is not authenticated, they can't communicate with the server

                // You can handle the client socket here for the rest of your server's functionality

                // Here is where you would handle the disconnection or shutdown of the client

            } catch (IOException e) {
                System.out.println("Failed to accept client on port " + port);
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        int port = 9876; // You can set your own port
        SecureSocketServer server = new SecureSocketServer(port);
        server.startServer();
    }
}