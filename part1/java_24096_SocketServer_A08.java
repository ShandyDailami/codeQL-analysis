import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_24096_SocketServer_A08 {
    private static final int PORT = 5000;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server started on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // Encrypt the client's message using A08_IntegrityFailure method
                String encryptedMessage = encryptClientMessage(socket.getInputStream().readUTF());

                // Send the encrypted message to the client
                socket.getOutputStream().writeUTF(encryptedMessage);
                socket.getOutputStream().flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // A08_IntegrityFailure method for encryption
    private static String encryptClientMessage(String message) {
        // Basic implementation: Replace each character with the next character in the alphabet
        StringBuilder encryptedMessage = new StringBuilder();
        for (char c : message.toCharArray()) {
            encryptedMessage.append((char) (c + 1));
        }
        return encryptedMessage.toString();
    }
}