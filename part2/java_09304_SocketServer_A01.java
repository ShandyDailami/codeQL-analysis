import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_09304_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server started on port " + PORT);

            while (true) {
                Socket client = server.accept();
                System.out.println("Client connected");

                // Perform some operation on the client here.

                // ...

                client.close();
            }
        } catch (IOException e) {
            System.out.println("Failed to start server: " + e.getMessage());
        }
    }
}