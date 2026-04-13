import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_30190_SocketServer_A01 {
    private static final int PORT = 4001;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server started on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected!");

                // Handle incoming request
                // In a real-world scenario, you would want to handle the request in a separate thread
                // and not block the client.
                handleRequest(socket);
           
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleRequest(Socket socket) {
        // Handle request here
        // This is just a placeholder, you would want to handle the request in a way
        // that is secure, like using SSL or other security protocols.
    }
}