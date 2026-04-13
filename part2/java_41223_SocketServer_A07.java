import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_41223_SocketServer_A07 {
    private static final String AUTHENTICATION_SUCCESS = "Authentication successful";
    private static final String AUTHENTICATION_FAILURE = "Authentication failure";

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8080);
            System.out.println("Server started at port 8080");

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected");

                // Simulate authentication
                if (authenticateClient(socket)) {
                    sendMessage(socket, AUTHENTICATION_SUCCESS);
                } else {
                    sendMessage(socket, AUTHENTICATION_FAILURE);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean authenticateClient(Socket socket) {
        // Add your authentication logic here
        // For this example, let's assume it's always true
        return true;
    }

    private static void sendMessage(Socket socket, String message) {
        try {
            socket.getOutputStream().write(message.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}