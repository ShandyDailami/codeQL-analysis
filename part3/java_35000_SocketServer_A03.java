import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_35000_SocketServer_A03 {

    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        // Create a server socket and listen for incoming connections
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                // Accept a new client connection
                try (Socket socket = server.accept()) {
                    System.out.println("New connection accepted from " + socket.getRemoteSocketAddress());

                    // Send a message to the client
                    String response = "Hello, you connected to the server!\n";
                    socket.getOutputStream().write(response.getBytes());
                }
            }
        }
    }
}