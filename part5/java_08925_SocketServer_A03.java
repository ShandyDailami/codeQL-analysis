import java.io.*;
import java.net.*;

public class java_08925_SocketServer_A03 {
    public static void main(String[] args) {
        int port = 8080;

        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("Server started on port " + port);

            while (true) {
                Socket socket = server.accept();

                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String message = in.readUTF();
                System.out.println("Received message: " + message);

                String response = processMessage(message);
                out.writeUTF(response);
                out.flush();

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String processMessage(String message) {
        // Here you can implement the logic for security sensitive operations related to injection
        // This is a simplified example, in a real-world scenario you'd need to validate and sanitize the input

        // For demonstration purposes, we just return the same message
        return message;
    }
}