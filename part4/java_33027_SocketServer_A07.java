import java.io.*;
import java.net.*;
import java.util.*;
import java.security.*;

public class java_33027_SocketServer_A07 {

    private static final String SERVER_SOFTWARE = "SecureSocketServer";
    private static final int DEFAULT_PORT = 9999;

    private static String hashPassword(String password) {
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
        byte[] hash = digest.digest(password.getBytes());
        return Base64.getEncoder().encodeToString(hash);
    }

    private static boolean authenticate(String clientPassword, String serverPassword) {
        return hashPassword(clientPassword).equals(serverPassword);
    }

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(DEFAULT_PORT);
            System.out.println("Server is listening on port " + DEFAULT_PORT);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
            System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        try (InputStream input = clientSocket.getInputStream();
             OutputStream output = clientSocket.getOutputStream()) {

            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            PrintWriter writer = new PrintWriter(output, true);

            String clientPassword = reader.readLine();
            String serverPassword = hashPassword(System.getProperty("user.password"));

            if (authenticate(clientPassword, serverPassword)) {
                writer.println("Successful login");
            } else {
                writer.println("Failed to authenticate");
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}