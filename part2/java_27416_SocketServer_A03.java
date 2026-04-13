import java.io.*;
import java.net.*;

public class java_27416_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server started on port 8080...");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected: " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF();
            System.out.println("Received message: " + message);

            // Simulate a security-sensitive operation related to injection
            // The example below is a placeholder, and the actual operation may be more complex
            String userInput = message.replace("'", "");
            out.writeUTF("User input: " + userInput);
            out.flush();
        }
    }
}