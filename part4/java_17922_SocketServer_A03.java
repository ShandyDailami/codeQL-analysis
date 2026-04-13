import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_17922_SocketServer_A03 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is running on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket.getRemoteSocketAddress());

                // Perform security-sensitive operation related to Injection
                performInjectionOperation(clientSocket);
            }
        } catch (IOException e) {
            System.out.println("Server failed to start: " + e.getMessage());
        }
    }

    private static void performInjectionOperation(Socket socket) {
        // A placeholder for a security-sensitive operation related to Injection
        // In a real application, this operation could involve things like:
        // 1. Receiving and handling commands from a client
        // 2. Executing SQL queries or other operations that might involve user input
        // 3. Sending back responses to the client

        // For the sake of simplicity, we'll print a greeting message to the client
        try {
            socket.getOutputStream().write("Hello, client!\n".getBytes());
        } catch (IOException e) {
            System.out.println("Error sending response: " + e.getMessage());
        }
    }
}