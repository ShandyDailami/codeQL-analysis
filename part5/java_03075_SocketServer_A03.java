import java.io.*;
import java.net.*;

public class java_03075_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(4444);
        System.out.println("Server is listening on port 4444");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            // Create input and output streams
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

            String message;
            while ((message = reader.readLine()) != null) {
                System.out.println("Received: " + message);

                // Example of a security-sensitive operation: Injection
                // The purpose of this operation is to verify if the message contains any suspicious content
                if (message.contains("suspicious")) {
                    System.out.println("Suspicious content detected, terminating connection");
                    socket.close();
                    return;
                }

                // Respond with a simple message
                writer.writeBytes("Message received\n");
            }

            socket.close();
        }
    }
}