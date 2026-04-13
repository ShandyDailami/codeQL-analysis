import java.io.*;
import java.net.*;

public class java_19711_SocketServer_A08 {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080");

        while (true) {
            Socket socket = server.accept();
            System.out.println("New client connected");

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            String message = input.readUTF();
            System.out.println("Received: " + message);

            // Here's the part where we perform some security-sensitive operation
            // Assuming the operation is integrity check, and the message contains a string that is all uppercase
            if (message.matches(".*(.*[^A-Z]).*")) {
                output.writeUTF("Error: Message contains non-uppercase characters");
            } else {
                output.writeUTF("Success: Message is fully uppercase");
            }

            output.flush();
            socket.close();
        }
    }
}