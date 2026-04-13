import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_06418_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is running on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected: " + socket.getInetAddress().getHostAddress());

            // Here, we're simulating a security-sensitive operation that could lead to unauthorized access.
            // This is just an example and not a real access control breach.
            if (checkAccess(socket)) {
                // Handle the client
            } else {
                System.out.println("Access denied for client: " + socket.getInetAddress().getHostAddress());
                socket.close();
            }
        }
    }

    // Simulating a security-sensitive operation that could lead to unauthorized access.
    private static boolean checkAccess(Socket socket) {
        // Here, we're simulating a random check to determine if the client is authorized.
        // This is not real access control. It's just a demonstration of security-sensitive operations.
        return Math.random() > 0.5;
    }
}