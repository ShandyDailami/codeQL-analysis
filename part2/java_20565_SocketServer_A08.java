import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_20565_SocketServer_A08 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected: " + socket.getInetAddress().getHostAddress());

                // Perform integrity check
                if (integrityCheck(socket)) {
                    // Handle the request
                    handleRequest(socket);
                } else {
                    System.out.println("Integrity check failed for client: " + socket.getInetAddress().getHostAddress());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean integrityCheck(Socket socket) {
        // Implement your integrity check logic here.
        // For simplicity, we will just return true.
        return true;
    }

    private static void handleRequest(Socket socket) {
        // Implement your request handling logic here.
        // For simplicity, we will just print the received message.
        System.out.println("Received request from: " + socket.getInetAddress().getHostAddress());
    }
}