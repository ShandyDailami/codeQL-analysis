import java.io.*;
import java.net.*;

public class java_11091_SocketServer_A03 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;
        try {
            server = new ServerSocket(PORT);
            System.out.println("Waiting for client connection...");
            socket = server.accept();
            System.out.println("Client connected");

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String clientMessage;
            while ((clientMessage = dis.readUTF()) != null) {
                System.out.println("Received from client: " + clientMessage);

                // perform security-sensitive operations related to A03_Injection
                // example: sanitize input
                clientMessage = sanitizeInput(clientMessage);

                dos.writeUTF("Server Response: " + clientMessage);
                dos.flush();
            }

            socket.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String sanitizeInput(String input) {
        // sanitize input for security-sensitive operations related to A03_Injection
        // for this example, we just return the input in lower case
        return input.toLowerCase();
    }
}