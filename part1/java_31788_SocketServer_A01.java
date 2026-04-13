import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_31788_SocketServer_A01 {

    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());

            // Simulate a security-sensitive operation related to A01_BrokenAccessControl
            String message = "Access to the system is restricted due to security policies.";
            clientSocket.getOutputStream().write(message.getBytes());
        }
    }
}