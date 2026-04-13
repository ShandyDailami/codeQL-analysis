import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_14898_SocketServer_A03 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        // Create a server socket
        ServerSocket serverSocket = new ServerSocket(PORT);

        System.out.println("Server is listening on port: " + PORT);

        while (true) {
            // Accept a new client connection
            Socket clientSocket = serverSocket.accept();

            System.out.println("A new client has connected: " + clientSocket.getRemoteSocketAddress());

            // Handle client connection in a separate thread
            new ClientHandler(clientSocket).start();
        }
    }
}

class ClientHandler extends Thread {
    private final Socket socket;

    public java_14898_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Receive a message from the client
        // The client's message should not contain any code to cause an injection attack
        // For example, if the client's message contains a "DROP TABLE users;" statement, the server will not execute it
    }
}