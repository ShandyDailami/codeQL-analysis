import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_29214_SocketServer_A07 {

    private static final String AUTHENTICATED_USERNAME = "admin";
    private static final String AUTHENTICATED_PASSWORD = "password";

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Server is listening on port 12345");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client accepted from " + clientSocket.getRemoteSocketAddress());

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true)) {

                String username = reader.readLine();
                String password = reader.readLine();

                if (!username.equals(AUTHENTICATED_USERNAME) || !password.equals(AUTHENTICATED_PASSWORD)) {
                    writer.println("Authentication failed");
                    writer.flush();
                    System.out.println("Authentication failed for " + clientSocket.getRemoteSocketAddress());
                    continue;
                }

                System.out.println("Authentication successful for " + clientSocket.getRemoteSocketAddress());
                // If authentication is successful, send a welcome message to the client
                writer.println("Welcome to the server");
                writer.flush();
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
        }
    }
}