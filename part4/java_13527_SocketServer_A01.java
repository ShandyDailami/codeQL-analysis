import java.net.*;
import java.io.*;

public class java_13527_SocketServer_A01 {
    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected!");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF();
            System.out.println("Received message: " + message);

            // Simulate some operation with the message.
            String response = processMessage(message);

            out.writeUTF(response);
            out.flush();

            socket.close();
        }
    }

    private static String processMessage(String message) {
        // This is a placeholder for a real-world operation.
        // In a real-world application, you would replace this with a secure operation.
        return "Server response: " + message;
    }
}