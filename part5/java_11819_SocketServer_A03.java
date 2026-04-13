import java.io.*;
import java.net.*;
import java.util.*;

public class java_11819_SocketServer_A03 {

    private static final String SERVER_MESSAGE = "Hello from server!";

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(6789);
        System.out.println("Server is running on port 6789");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected!");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF();
            System.out.println("Message received: " + message);

            if (message.equals("exit")) {
                System.out.println("Client disconnected");
                break;
            }

            // Encryption
            String encryptedMessage = encrypt(message);
            out.writeUTF(encryptedMessage);
            out.flush();
       
        }

        server.close();
    }

    private static String encrypt(String message) {
        byte[] bytes = message.getBytes();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < bytes.length; i++) {
            sb.append((char) (bytes[i] + 5));
        }

        return sb.toString();
    }
}