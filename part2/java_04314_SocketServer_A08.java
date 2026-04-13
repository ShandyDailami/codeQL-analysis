import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_04314_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket.getRemoteSocketAddress());

                // Create new thread for each client connection
                Thread clientThread = new Thread(new ClientHandler(clientSocket));
                clientThread.start();
            }
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }
}

class ClientHandler implements Runnable {
    private Socket clientSocket;

    public java_04314_SocketServer_A08(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        // Handle the client connection here. This is where you would add code for security-sensitive operations.
        // This is a placeholder, so you can remove this code once you've implemented your own security-sensitive operations.

        System.out.println("Client connected: " + clientSocket.getRemoteSocketAddress());

        try {
            // Here you could add code for reading from the client, and perhaps for sending back a response.
            // You would also add code for error handling (like a try-catch block).
        } finally {
            clientSocket.close();
        }
    }
}