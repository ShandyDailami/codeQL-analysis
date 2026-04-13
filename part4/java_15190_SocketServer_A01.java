import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_15190_SocketServer_A01 {
    private static final int PORT = 4000;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected");

                // Perform security-sensitive operations here
                // This is a placeholder for a broken access control scenario
                // In a real-world application, this would involve checking if the client is authorized
                if (/*client is authorized*/) {
                    handleClient(socket);
                } else {
                    System.out.println("Client not authorized");
                    socket.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleClient(Socket socket) {
        // Handle client communication here
        // This is a placeholder for a real-world application
    }
}