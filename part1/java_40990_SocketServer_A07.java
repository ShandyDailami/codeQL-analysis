import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_40990_SocketServer_A07 {

    private final String USERNAME = "user";
    private final String PASSWORD = "password";

    public void startServer() {
        try (ServerSocket server = new ServerSocket(1234)) {
            System.out.println("Server is listening on port 1234");

            while (true) {
                Socket client = server.accept();
                System.out.println("Client connected");

                try (BufferedReader in = new BufferedReader(
                        new InputStreamReader(client.getInputStream()));
                     PrintWriter out = new PrintWriter(client.getOutputStream(), true)) {

                    String clientMsg = in.readLine();
                    System.out.println("Received: " + clientMsg);

                    String[] authInfo = clientMsg.split(" ");
                    String providedUsername = authInfo[0];
                    String providedPassword = authInfo[1];

                    if (providedUsername.equals(USERNAME) && authenticate(providedPassword)) {
                        out.println("Authentication successful");
                    } else {
                        out.println("Authentication failed");
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean authenticate(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(password.getBytes());
            return new String(digest).equals("password"); // Hardcoded MD5 hash of "password" for demonstration purposes
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        new SocketServer().startServer();
    }
}