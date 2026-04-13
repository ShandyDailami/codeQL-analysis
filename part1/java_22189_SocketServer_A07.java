import java.io.*;
import java.net.*;
import java.util.*;

public class java_22189_SocketServer_A07 {
    private static final int PORT = 8080;
    private static final String AUTHENTICATED_USER = "admin";
    private static final String AUTHENTICATED_PASSWORD = "password";

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started on port: " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getRemoteSocketAddress());

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            String clientMessage = reader.readLine();
            System.out.println("Received: " + clientMessage);

            String[] authInfo = clientMessage.split(" ");
            String clientUsername = authInfo[0];
            String clientPassword = authInfo[1];

            if (clientUsername.equals(AUTHENTICATED_USER) && clientPassword.equals(AUTHENTICATED_PASSWORD)) {
                System.out.println("Authentication successful");
                writer.println("Authentication successful");
            } else {
                System.out.println("Authentication failed");
                writer.println("Authentication failed");
                socket.close();
            }
        }
    }
}