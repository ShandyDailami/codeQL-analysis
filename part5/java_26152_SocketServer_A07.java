import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_26152_SocketServer_A07 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected!");

                // Perform authentication and handle failed authentication
                if (authenticate(socket)) {
                    handleClient(socket);
                } else {
                    System.out.println("Authentication failed. Closing connection.");
                    socket.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean authenticate(Socket socket) {
        // Implement authentication logic here. For now, we'll just return true.
        return true;
    }

    private static void handleClient(Socket socket) {
        // Implement client handling logic here. For now, we'll just print a message.
        System.out.println("Handling client...");
    }
}