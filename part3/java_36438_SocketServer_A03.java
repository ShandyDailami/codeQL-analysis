import java.io.*;
import java.net.*;

public class java_36438_SocketServer_A03 {
    public static void main(String[] args) {
        int port = 1234;

        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("Server is listening on port: " + port);

            while (true) {
                Socket socket = server.accept();
                System.out.println("A new client has connected: " + socket.getRemoteSocketAddress());

                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());

                String message = input.readUTF();
                System.out.println("Received message from client: " + message);

                String response = processMessage(message);
                output.writeUTF(response);
                System.out.println("Sent response to client: " + response);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String processMessage(String message) {
        // Injection example.
        // This is a very basic example of an injection point.
        // In a real application, you would not use this method as it is very simple.
        // Instead, you would use a more complex method for processing the message.
        return "Server response: " + message;
    }
}