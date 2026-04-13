import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_32273_SocketServer_A01 {
    private static final int PORT = 8080;
    private static final int MAX_CONNECTIONS = 1;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            // Limit the number of simultaneous connections
            int connections = 0;
            while (connections < MAX_CONNECTIONS) {
                Socket socket = serverSocket.accept();
                System.out.println("New connection from " + socket.getRemoteSocketAddress());

                // Perform security-sensitive operations
                // ...

                connections++;
            }
        } catch (IOException e) {
            System.err.println("Failed to start the server on port " + PORT);
            e.printStackTrace();
        }
    }
}