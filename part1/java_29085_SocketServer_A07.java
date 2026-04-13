import java.io.*;
import java.net.*;
import java.util.*;

public class java_29085_SocketServer_A07 {
    private static final String USERNAME = "test";
    private static final String PASSWORD = "test";

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(4444);
        System.out.println("Server is running and listening for connections on port 4444...");

        while (true) {
            Socket socket = server.accept();
            System.out.println("A client has connected!");

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            String clientMessage = reader.readLine();
            String[] messageParts = clientMessage.split(" ");

            String clientUsername = messageParts[0];
            String clientPassword = messageParts[1];

            if (clientUsername.equals(USERNAME) && clientPassword.equals(PASSWORD)) {
                writer.println("Authentication successful!");
            } else {
                writer.println("Authentication failed!");
            }

            writer.close();
            socket.close();
        }
    }
}