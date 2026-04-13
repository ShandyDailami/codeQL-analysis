import java.net.ServerSocket;
import java.net.Socket;

public class java_09756_SocketServer_A03 {
    private static final int PORT = 1234;

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = null;
        try {
            // Create a server socket and listen for incoming connections
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                // Wait for a connection
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected!");

                // Handle the client connection in a separate thread
                ClientHandler handler = new ClientHandler(clientSocket);
                Thread thread = new Thread(handler);
                thread.start();
            }
        } finally {
            serverSocket.close();
        }
    }
}

class ClientHandler implements Runnable {
    private final Socket socket;

    public java_09756_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Handle the client connection here
        // This is a basic example and does not include any security-sensitive operations
    }
}