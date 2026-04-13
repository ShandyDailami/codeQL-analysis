import java.io.*;
import java.net.*;

public class java_38428_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF();
            System.out.println("Received: " + message);

            if (message.length() > 0) {
                String response = processInput(message);
                out.writeUTF(response);
            }

            socket.close();
        }
    }

    private static String processInput(String input) {
        // This is a placeholder for a potentially dangerous operation
        // This is a basic example of an injection attack
        // The purpose of this operation is to demonstrate security-sensitive operations
        return "Server response: " + input;
    }
}