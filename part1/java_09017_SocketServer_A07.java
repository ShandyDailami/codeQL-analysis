import java.io.*;
import java.net.*;
import java.util.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_09017_SocketServer_A07 {
    private static final String HASH_ALGORITHM = "SHA-256";
    private static final String SERVER_SOCKET_ADDRESS = "localhost";
    private static final int SERVER_PORT = 8080;

    public static void main(String[] args) {
        try {
            // Create a server socket
            ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
            System.out.println("Server is listening on " + SERVER_SOCKET_ADDRESS + ":" + SERVER_PORT);

            while (true) {
                // Accept a client connection
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());

                // Create input and output streams
                DataInputStream inputStream = new DataInputStream(clientSocket.getInputStream());
                DataOutputStream outputStream = new DataOutputStream(clientSocket.getOutputStream());

                // Read the username from the client
                String clientUsername = inputStream.readUTF();

                // Hash the password (for security)
                MessageDigest digest = MessageDigest.getInstance(HASH_ALGORITHM);
                byte[] hash = digest.digest(clientUsername.getBytes());

                // Send the hash back to the client
                outputStream.writeUTF(new String(hash));

                // Close the connection
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Unable to find hash algorithm " + HASH_ALGORITHM);
        }
    }
}