import java.io.*;
import java.net.*;

public class java_41533_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(6666);
        System.out.println("Server started...");

        while (true) {
            Socket client = server.accept();
            System.out.println("New client connected...");

            // Create streams for reading and writing
            DataInputStream in = new DataInputStream(client.getInputStream());
            DataOutputStream out = new DataOutputStream(client.getOutputStream());

            // Receive a message from the client
            String message = in.readUTF();
            System.out.println("Received: " + message);

            // Check if the message is a valid command
            if (message.equals("exit")) {
                out.writeUTF("Exited the chat");
                client.close();
            } else {
                out.writeUTF("Invalid command");
            }

            // Close the streams
            out.close();
            in.close();
        }
    }
}