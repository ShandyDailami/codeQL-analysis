import java.io.*;
import java.net.*;

public class java_17003_SocketServer_A01 {
    private static final String SERVER_STATUS = "Server Running";
    private static final String SERVER_STOP_STATUS = "Server Stopped";

    public static void main(String[] args) {
        int port = 6000; // Default port
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // Perform security-sensitive operations here
                // For instance, check if the client is authorized to connect
                if (checkAuthorization(socket)) {
                    handleClient(socket);
                } else {
                    System.out.println("Unauthorized access attempt from client");
                    socket.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void handleClient(Socket socket) {
        // Handle client communication here
    }

    private static boolean checkAuthorization(Socket socket) {
        // Implement authorization checks here
        // For now, we'll assume the client is authorized if it successfully establishes a connection
        return true;
    }
}