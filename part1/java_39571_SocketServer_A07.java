import java.io.*;
import java.net.*;
import java.util.*;

public class java_39571_SocketServer_A07 {

    private static final String AUTH_USERNAME = "user";
    private static final String AUTH_PASSWORD = "password";

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(4444);
        System.out.println("Server started");

        while (true) {
            Socket socket = server.accept();
            System.out.println("New client connected");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String clientMessage = in.readLine();
            String serverMessage = handleClientRequest(clientMessage);

            out.writeBytes(serverMessage + "\n");
            socket.close();
        }
    }

    private static String handleClientRequest(String clientRequest) {
        String[] requestParts = clientRequest.split(" ");
        String username = requestParts[1];
        String password = requestParts[2];

        if (isAuthenticated(username, password)) {
            return "Authentication successful";
        } else {
            throw new RuntimeException("Authentication failed");
        }
    }

    private static boolean isAuthenticated(String username, String password) {
        return AUTH_USERNAME.equals(username) && AUTH_PASSWORD.equals(password);
    }
}