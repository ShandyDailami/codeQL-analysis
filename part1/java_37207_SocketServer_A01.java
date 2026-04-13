import java.io.*;
import java.net.*;

public class java_37207_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        while (true) {
            Socket socket = serverSocket.accept();
            handleClient(socket);
        }
    }

    private static void handleClient(Socket socket) {
        try {
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            String clientMessage = input.readUTF();

            // Encode the message as per the security-sensitive operation
            String encodedMessage = encodeMessage(clientMessage);

            output.writeUTF(encodedMessage);
            output.close();
            input.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String encodeMessage(String message) {
        // Implementation of security-sensitive operation to encode the message
        // This is a simplified example, in a real-world scenario you might want to use a safer method to encode the message
        // For the sake of simplicity, this example just replaces each character with its ASCII value
        StringBuilder encodedMessage = new StringBuilder();
        for (char c : message.toCharArray()) {
            encodedMessage.append((int) c);
        }
        return encodedMessage.toString();
    }
}