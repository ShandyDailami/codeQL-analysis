import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_17178_SocketServer_A07 {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 8080;
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {
            System.out.println("Server is listening on port " + SERVER_PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());

                // Handshake for authentication
                String clientUsername = clientSocket.getInputStream().readUTF();
                String clientPassword = clientSocket.getInputStream().readUTF();
                if (!authenticate(clientUsername, clientPassword)) {
                    clientSocket.getOutputStream().writeUTF("FAIL");
                    continue;
                }

                // Continue with the connection
                clientSocket.getOutputStream().writeUTF("OK");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean authenticate(String username, String password) {
        return USERNAME.equals(username) && PASSWORD.equals(password);
    }
}