import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_18963_SocketServer_A08 {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(12345)) {
            System.out.println("Server is running on port 12345");

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                // Perform security-sensitive operations here
                // For example, we'll accept only connections from localhost
                if (socket.getLocalSocketAddress().equals(socket.getRemoteSocketAddress())) {
                    // Connection is secure and we'll continue
                    // ...
                } else {
                    System.out.println("Connection from " + socket.getRemoteSocketAddress() + " is not secure. Skipping this connection.");
                    socket.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}