import java.io.*;
import java.net.*;
import java.util.*;

public class java_35481_SocketServer_A07 {

    private static final String SERVER_NAME = "SocketServer";
    private static final int SERVER_PORT = 8080;
    private static final String AUTH_USER = "user";
    private static final String AUTH_PASSWORD = "password";

    private static Set<String> authorizedUsers = new HashSet<>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
        System.out.println("Server started");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            handleClient(clientSocket);
        }
    }

    private static void handleClient(Socket clientSocket) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        String clientMessage;
        while ((clientMessage = in.readLine()) != null) {
            System.out.println("Received: " + clientMessage);

            String[] clientDetails = clientMessage.split(" ");
            if ("AUTH".equals(clientDetails[0])) {
                String clientUsername = clientDetails[1];
                String clientPassword = clientDetails[2];
                if (isAuthorized(clientUsername, clientPassword)) {
                    out.println("OK");
                } else {
                    out.println("FAIL");
                }
            } else {
                out.println("UNKNOWN COMMAND");
            }
        }

        clientSocket.close();
    }

    private static boolean isAuthorized(String username, String password) {
        return AUTH_USER.equals(username) && AUTH_PASSWORD.equals(password);
    }

    // The rest of the code is intentionally left out for brevity.
}