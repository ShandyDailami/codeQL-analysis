import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_29380_SocketServer_A01 {

    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("New client connected: " + clientSocket.getRemoteSocketAddress());

            // Perform security-sensitive operations related to A01_BrokenAccessControl

            // Handle the communication with the client
            handleClient(clientSocket);
        }
    }

    private static void handleClient(Socket clientSocket) {
        // TODO: Add your code to handle the communication with the client
    }
}