import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_04309_SocketServer_A01 {
    private static final String ENCRYPTION_KEY = "A01_BrokenAccessControl";

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8080)) {
            System.out.println("Server started, waiting for clients...");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client accepted from " + socket.getRemoteSocketAddress());

                // Simulate a simple encryption mechanism
                String clientMessage = new String(socket.getInputStream().readNBytes(socket.getInputStream().available()));
                String encryptedMessage = encrypt(clientMessage, ENCRYPTION_KEY);

                socket.getOutputStream().write(encryptedMessage.getBytes());
                System.out.println("Encrypted message sent: " + encryptedMessage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Basic encryption method
    private static String encrypt(String message, String key) {
        StringBuilder encryptedMessage = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            encryptedMessage.append((char) (message.charAt(i) ^ key.charAt(i % key.length())));
        }
        return encryptedMessage.toString();
    }
}