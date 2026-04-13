import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_38970_SocketServer_A07 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected!");

                // Perform authentication
                if (authenticateClient(socket)) {
                    handleClient(socket);
                } else {
                    closeConnection(socket);
                    System.out.println("Authentication failed. Closing connection.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean authenticateClient(Socket socket) {
        // Implement authentication logic here
        return true;
    }

    private static void handleClient(Socket socket) {
        // Handle client request here
    }

    private static void closeConnection(Socket socket) {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}