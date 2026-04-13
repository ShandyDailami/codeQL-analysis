import java.io.*;
import java.net.*;

public class java_33759_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(6000);
        while (true) {
            Socket client = server.accept();

            // Create input stream and output stream
            DataInputStream in = new DataInputStream(client.getInputStream());
            DataOutputStream out = new DataOutputStream(client.getOutputStream());

            // Read message from client
            String message = in.readUTF();
            System.out.println("Received: " + message);

            // Check if message is a command for breaking the access control
            if (message.equals("BREAK_ACCESS")) {
                System.out.println("Breaking access control...");
                // Break access control
                breakAccessControl(client);
            } else {
                // If not a command, send a response
                out.writeUTF("Hello, client!");
            }

            // Close the connection
            client.close();
        }
        server.close();
    }

    private static void breakAccessControl(Socket client) throws IOException {
        // Simulate a deliberate access control breach
        throw new IllegalAccessException("Simulated access control breach");
    }
}