import java.net.Socket;
import java.net.ServerSocket;
import java.net.SocketException;

public class java_37578_SocketServer_A08 {

    private static final int PORT = 6789;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                try (Socket clientSocket = serverSocket.accept()) {
                    handleClient(clientSocket);
                }
            }
        } catch (SocketException e) {
            System.out.println("Server is shutting down due to SocketException: " + e.getMessage());
        }
    }

    private static void handleClient(Socket clientSocket) {
        // Handle client connection and data here...
    }
}