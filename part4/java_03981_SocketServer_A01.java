import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_03981_SocketServer_A01 {
    private static final int PORT = 9876;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("A new client is connected from " + clientSocket.getRemoteSocketAddress());

                // Create a new thread for each client
                Thread thread = new Thread(new ClientHandler(clientSocket));
                thread.start();
            }
        } catch (IOException e) {
            System.out.println("Failed to listen on port " + PORT + ". Reason: " + e.getMessage());
            System.exit(-1);
        }
    }
}

class ClientHandler implements Runnable {
    private final Socket clientSocket;

    public java_03981_SocketServer_A01(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        // Handling the client's request for security-sensitive operations
        // ... (Here you can put your logic related to security-sensitive operations)

        // Closing the connection with the client
        closeConnection(clientSocket);
    }

    private void closeConnection(Socket socket) {
        try {
            if (socket != null && socket.isConnected()) {
                socket.close();
            }
        } catch (IOException e) {
            System.out.println("Failed to close connection. Reason: " + e.getMessage());
        }
    }
}