import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_05832_SocketServer_A07 {
    private static final int PORT = 4000;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is running on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected: " + socket.getRemoteSocketAddress());

            // Security-sensitive operation: Authentication
            if (authenticate(socket)) {
                handleRequest(socket);
            } else {
                closeConnection(socket);
           
                System.out.println("Authentication failed, connection closed.");
            }
        }
    }

    private static boolean authenticate(Socket socket) {
        // Implementation of authentication here
        return true;
    }

    private static void handleRequest(Socket socket) {
        // Handle request here
    }

    private static void closeConnection(Socket socket) {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}