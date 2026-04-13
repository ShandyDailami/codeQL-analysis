import java.io.*;
import java.net.*;
import java.util.*;

public class java_20183_SocketServer_A07 {

    private static final int PORT = 4446;
    private static final String AUTHORIZED_USERS = "auth_users.txt";

    private Set<String> authorizedUsers = new HashSet<>();

    public java_20183_SocketServer_A07() {
        loadAuthorizedUsers();
    }

    private void loadAuthorizedUsers() {
        try (BufferedReader br = new BufferedReader(new FileReader(AUTHORIZED_USERS))) {
            String line;
            while ((line = br.readLine()) != null) {
                authorizedUsers.add(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() throws IOException {
        try (ServerSocket server = new ServerSocket(PORT)) {
            while (true) {
                Socket socket = server.accept();
                handleRequest(socket);
            }
        }
    }

    private void handleRequest(Socket socket) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {

            String clientMessage = reader.readLine();
            System.out.println("Received: " + clientMessage);

            if (isAuthorized(clientMessage)) {
                System.out.println("Authorized user. Sending response...");
                writer.println("Response from server: Authorized user");
            } else {
                System.out.println("Unauthorized user. Sending response...");
                writer.println("Response from server: Unauthorized user");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean isAuthorized(String username) {
        return authorizedUsers.contains(username);
    }

    public static void main(String[] args) throws IOException {
        new Server().start();
    }
}