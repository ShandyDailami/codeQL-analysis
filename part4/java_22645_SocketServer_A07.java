import java.io.*;
import java.net.*;
import java.util.*;

public class java_22645_SocketServer_A07 {
    private static final String PASSWORD = "password";
    private static boolean authenticated = false;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8189);
        System.out.println("Waiting for client on port " + server.getLocalPort());
        while (true) {
            Socket socket = server.accept();
            System.out.println("Accepted new connection from " + socket.getRemoteSocketAddress());

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            // Read username
            String clientName = input.readUTF();
            System.out.println(clientName + " is trying to connect");

            // Authenticate the client
            authenticateClient(clientName);

            if (authenticated) {
                output.writeUTF("Connection successful");
                System.out.println("Connection successful");
            } else {
                output.writeUTF("Connection failed");
                System.out.println("Connection failed");
            }

            socket.close();
        }
    }

    private static void authenticateClient(String clientName) throws IOException {
        String clientPassword = input.readUTF();
        authenticated = clientPassword.equals(PASSWORD);
    }
}