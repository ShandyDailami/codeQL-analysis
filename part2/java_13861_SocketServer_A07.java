import java.io.*;
import java.net.*;
import java.util.*;

public class java_13861_SocketServer_A07 {
    private static final String AUTH_FAILURE_MESSAGE = "Authentication failed";
    private static final String CORRECT_USERNAME_PASSWORD = "admin:admin";

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(4444);
        System.out.println("Server started!");

        while (true) {
            Socket client = server.accept();
            System.out.println("Client connected!");

            DataInputStream in = new DataInputStream(client.getInputStream());
            DataOutputStream out = new DataOutputStream(client.getOutputStream());

            // Read the username and password from the client
            String clientCredentials = in.readUTF();
            String[] credentials = clientCredentials.split(":");

            // Check if the username and password match
            if (Arrays.equals(credentials, CORRECT_USERNAME_PASSWORD.split(":"))) {
                // If they match, send a successful authentication message
                out.writeUTF(AUTH_FAILURE_MESSAGE);
            } else {
                // If they don't match, send an authentication failure message
                out.writeUTF(AUTH_FAILURE_MESSAGE);
            }

            out.flush();
            client.close();
        }
    }
}