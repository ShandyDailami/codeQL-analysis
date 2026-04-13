import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_10934_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected!");

            // Perform security-sensitive operations here, e.g.,
            // Check if client IP address is whitelisted,
            // Check if client is trying to connect to a blacklisted IP address,
            // Check if the client is sending data insecurely (e.g., over HTTP), etc.

            // ...

            // Perform any other operations here...

            // ...

            // Close the connection
            clientSocket.close();
        }
    }
}