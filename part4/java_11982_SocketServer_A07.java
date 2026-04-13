import java.net.*;
import java.io.*;
import java.util.*;

public class java_11982_SocketServer_A07 {

    private static final String MESSAGE_SEPARATOR = "\n";
    private static final String AUTH_KEY = "mySecretKey";

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(12345);

        while (true) {
            System.out.println("Waiting for client on port: " + server.getLocalPort());
            Socket clientSocket = server.accept();

            System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

            String message = in.readUTF();
            System.out.println("Client says: " + message);

            if (isAuthorized(message)) {
                out.writeUTF("Successful authentication. Welcome!");
            } else {
                out.writeUTF("Authentication failed. Please try again.");
            }

            clientSocket.close();
        }
    }

    private static boolean isAuthorized(String message) {
        return AUTH_KEY.equals(message);
    }
}