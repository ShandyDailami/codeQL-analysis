import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_01886_SocketServer_A07 {
    private static final String AUTH_TOKEN = "secret"; // This should be a secret value

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Server started on port 12345");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected");

                // Authenticate the client
                String clientToken = clientSocket.getRemoteSocketAddress().toString(); // Get the client's IP address as a string
                if (!clientToken.equals(AUTH_TOKEN)) {
                    System.out.println("Authentication failed, disconnecting");
                    clientSocket.close();
                    continue;
                }

                // Handle the client, e.g., read and write data
                // ...

                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}