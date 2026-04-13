import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_24582_SocketServer_A07 {
    private static final int PORT = 8080;
    private static ServerSocket serverSocket;

    public static void main(String[] args) {
        startServer();
    }

    private static void startServer() {
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server started on port " + PORT);
            handleClient(serverSocket.accept());
        } catch (IOException e) {
            System.out.println("Error occurred while starting server: " + e.getMessage());
       
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    System.out.println("Error occurred while closing server: " + e.getMessage());
                }
            }
        }
    }

    private static void handleClient(Socket clientSocket) {
        // Implement your client-handling code here
    }
}