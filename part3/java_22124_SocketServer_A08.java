import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_22124_SocketServer_A08 {

    public static final String SALT = "secure_salt";

    public static void main(String[] args) {
        try {
            // Create a server socket
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server started");

            while (true) {
                // Accept a new client
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // Perform security-sensitive operations
                String clientPassword = handleClientConnection(socket);
                if (!isPasswordCorrect(clientPassword)) {
                    System.out.println("Authentication failed. Closing connection.");
                    socket.close();
                    continue;
                }

                // Send a greeting to the client
                socket.getOutputStream().write("Hello, client!".getBytes());

                // Close the connection
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String handleClientConnection(Socket socket) {
        // Perform handshake with the client
        try {
            // Receive the client's password
            byte[] bytes = new byte[1024];
            socket.getInputStream().read(bytes);
            String clientPassword = new String(bytes);

            // Hash the client's password with a unique salt
            MessageDigest md = MessageDigest.getInstance("MD5");
            String clientPasswordHash = md.digest(clientPassword.getBytes()) + SALT;

            // Send the client's password hash back to the client
            socket.getOutputStream().write(clientPasswordHash.getBytes());

            return clientPassword;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static boolean isPasswordCorrect(String password, String passwordHash) {
        // Hash the password with a unique salt and compare it to the password hash
        MessageDigest md = MessageDigest.getInstance("MD5");
        String correctPasswordHash = md.digest(password.getBytes()) + SALT;
        return correctPasswordHash.equals(passwordHash);
    }

}