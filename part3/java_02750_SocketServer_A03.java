import java.io.*;
import java.net.*;

public class java_02750_SocketServer_A03 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server started at port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected at " + socket.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String message = in.readUTF();
                System.out.println("Received: " + message);

                // Perform security-sensitive operations related to A03_Injection
                String sanitizedMessage = sanitizeInput(message);

                out.writeUTF("Hello, " + sanitizedMessage + ". You are connected at " + socket.getRemoteSocketAddress());
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String sanitizeInput(String input) {
        // Implement sanitization logic here
        // This is a placeholder, make sure to replace it with your own sanitization logic
        return input;
    }
}