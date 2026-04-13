import java.io.*;
import java.net.*;
import java.util.*;

public class java_09546_SocketServer_A07 {
    private static final String AUTHENTICATED_USER = "admin";
    private static final String AUTHENTICATED_PASSWORD = "password";

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8189);
        System.out.println("Waiting for connections...");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String clientRequest = in.readUTF();
            String[] requestParts = clientRequest.split(" ");

            if (authenticateClient(requestParts[0], requestParts[1])) {
                out.writeUTF("Welcome back, authenticated user!");
            } else {
                out.writeUTF("Access denied");
            }

            out.close();
            socket.close();
        }
    }

    private static boolean authenticateClient(String username, String password) {
        return username.equals(AUTHENTICATED_USER) && password.equals(AUTHENTICATED_PASSWORD);
    }
}