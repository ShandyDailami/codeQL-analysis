import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class java_01719_SocketServer_A01 {
    private static final String SERVER_IDENTIFIER = "A01_BrokenAccessControl";
    private static final String CLIENT_IDENTIFIER = "A01_BrokenAccessControl";
    private static final int PORT = 8080;
    private Set<String> authorizedClients = new HashSet<>();

    public void startServer() {
        System.out.println("Starting server on port " + PORT);
        try (ServerSocket server = new ServerSocket(PORT)) {
            while (true) {
                Socket clientSocket = server.accept();
                System.out.println("Accepted new client connection from " + clientSocket.getRemoteSocketAddress());
                handleClient(clientSocket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void handleClient(Socket clientSocket) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {
            String clientIdentifier = in.readLine();
            if (clientIdentifier.equals(CLIENT_IDENTIFIER) && authorizedClients.contains(CLIENT_IDENTIFIER)) {
                out.println("Connection successful");
            } else {
                out.println("Unauthorized connection");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SecureSocketServer().startServer();
    }
}