import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_10976_SocketServer_A03 {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {
            System.out.println("Server started on port " + SERVER_PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket.getRemoteSocketAddress());

                // This is a simple check for injection, it is not secure
                // The injection can be done by sending a SQL query string
                String injectionCheck = "SELECT * FROM users WHERE username='" + clientSocket.getRemoteSocketAddress() + "'";
                System.out.println("Injection check: " + injectionCheck);

                // This will work only if we send the SQL query string
                // For real world application, use a more secure method to handle the data
                // clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}