import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_15382_SocketServer_A01 {
    private static final int PORT = 9876;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is running and waiting for a client to connect...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected!");

                // Here we use a simplistic encryption technique for demonstration purposes
                // In a real-world scenario, you would likely want to use a more secure protocol
                byte[] bytes = socket.getInputStream().readAllBytes();
                String encryptedMessage = new String(bytes);
                String decryptedMessage = decryptMessage(encryptedMessage);
                System.out.println("Decrypted message: " + decryptedMessage);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String decryptMessage(String encryptedMessage) {
        // This is a simple Caesar cipher decryption technique
        // In a real-world scenario, you would likely want to use a more secure protocol
        char[] chars = encryptedMessage.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isAlphabetic(chars[i])) {
                chars[i] = (char) ((chars[i] - 'a' + 3) % 26 + 'a');
            }
        }
        return new String(chars);
    }
}