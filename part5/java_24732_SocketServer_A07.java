import java.io.*;
import java.net.*;

public class java_24732_SocketServer_A07 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(6666);
            System.out.println("Server started on port 6666");

            while (true) {
                Socket client = server.accept();
                System.out.println("Client connected");

                // Create input and output streams
                DataInputStream in = new DataInputStream(client.getInputStream());
                DataOutputStream out = new DataOutputStream(client.getOutputStream());

                // Read the message from the client
                String message = in.readUTF();
                System.out.println("Received message: " + message);

                // Authenticate the client
                if (authenticate(message)) {
                    out.writeUTF("Authentication successful");
                } else {
                    out.writeUTF("Authentication failed");
               
                }

                // Close the streams
                out.close();
                in.close();
                client.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean authenticate(String message) {
        // Implement authentication logic here, for example:
        return message.equals("secure-password");
    }
}