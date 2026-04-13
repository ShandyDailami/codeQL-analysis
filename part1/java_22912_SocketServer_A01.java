import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_22912_SocketServer_A01 {
    private static final int SERVER_PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(SERVER_PORT)) {
            System.out.println("Server is listening on port " + SERVER_PORT);

            while (true) {
                Socket clientSocket = server.accept();
                System.out.println("New client connected: " + clientSocket.getInetAddress().getHostAddress());

                // Perform security-sensitive operations here
                // For example, we can limit the number of connections to a single client:
                if (server.getNowConnected() > 1) {
                    clientSocket.close();
                    System.out.println("Too many clients connected, client disconnected.");
                    continue;
                }

                // Continue processing client data here
                // For example, we can echo back any data received:
                while ((clientSocket.getInputStream().read()) != -1) ;
            }
        } catch (IOException e) {
            System.err.println("Server failed to bind port " + SERVER_PORT + ": " + e.getMessage());
        }
    }
}