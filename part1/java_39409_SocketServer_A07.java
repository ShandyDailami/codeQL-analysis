import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_39409_SocketServer_A07 {
    private static final int PORT = 5000;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started. Listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected. Socket ID: " + socket.getRemoteSocketAddress());

                // Start a new thread to handle the client connection
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error while accepting client connection");
        }
    }
}

class ClientHandler extends Thread {
    private final Socket socket;

    public java_39409_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // TODO: Implement authentication
        // For the sake of simplicity, we will just check if the client IP is allowed
        // in this example. In a real application, you would likely want to use a more secure method.
        String clientIP = socket.getRemoteSocketAddress().toString();
        if (!"127.0.0.1".equals(clientIP)) {
            System.out.println("Connection from " + clientIP + " rejected due to security reasons");
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }

        // TODO: Handle client's request
        // In a real application, you would likely want to read from and write to the socket
        // to handle the request and respond accordingly.

        System.out.println("Connection from " + clientIP + " accepted successfully");
    }
}