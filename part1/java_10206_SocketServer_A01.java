import java.io.*;
import java.net.*;

public class java_10206_SocketServer_A01 {

    private static final String QUIT = "quit";

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(4444);
        System.out.println("Server is listening on port 4444...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("A client has connected...");

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            String clientMessage = dataInputStream.readUTF();

            if (clientMessage.equals(QUIT)) {
                System.out.println("Client has disconnected...");
                socket.close();
            } else {
                // Simple encryption for demonstration purposes.
                // This is not secure for any serious use-case.
                String encryptedMessage = encryptMessage(clientMessage);
                dataOutputStream.writeUTF(encryptedMessage);
                dataOutputStream.flush();
            }
        }
    }

    private static String encryptMessage(String message) {
        // Here we're using a simple Caesar cipher for demonstration.
        // In a real-world scenario, you'd use a more secure encryption method.
        StringBuilder encryptedMessage = new StringBuilder();
        for (char c : message.toCharArray()) {
            encryptedMessage.append((char) (c + 3));
        }
        return encryptedMessage.toString();
    }

}