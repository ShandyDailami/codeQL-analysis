import java.io.*;
import java.net.*;

public class java_16453_SocketServer_A08 {
    private static int DEFAULT_PORT = 8080;
    private static ServerSocket server;

    public static void main(String[] args) {
        try {
            server = new ServerSocket(DEFAULT_PORT);
            System.out.println("Server is running on port " + DEFAULT_PORT);

            while (true) {
                Socket client = server.accept();
                System.out.println("A new client has connected");

                DataInputStream in = new DataInputStream(client.getInputStream());
                DataOutputStream out = new DataOutputStream(client.getOutputStream());

                // Receive the message from the client
                String message = in.readUTF();
                System.out.println("Received message from client: " + message);

                // Check if the message is valid
                if (isValidMessage(message)) {
                    System.out.println("Message is valid, sending response back");
                    out.writeUTF("Valid message received");
                } else {
                    System.out.println("Invalid message, sending response back");
                    out.writeUTF("Invalid message received");
                }

                out.close();
                in.close();
                client.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static boolean isValidMessage(String message) {
        // Here you can implement your security-sensitive operation related to A08_IntegrityFailure
        // This operation could involve hashing, encoding, decoding, etc.
        // For the purpose of this example, let's just return true for simplicity
        return true;
    }
}