import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_29835_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Server is listening on port 12345");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            // Authenticate the client using basic authentication
            String clientUsername = clientSocket.getInetAddress().getHostAddress();
            String clientPassword = "password"; // Hardcoded for simplicity

            if ("username".equals(clientUsername) && "password".equals(clientPassword)) {
                // Client is authenticated, proceed with communication
                handleClient(clientSocket);
            } else {
                // Client is not authenticated, close the connection
                clientSocket.close();
                System.out.println("Client authentication failed");
            }
        }
    }

    private static void handleClient(Socket clientSocket) throws IOException {
        // Handle communication with the client here
    }
}