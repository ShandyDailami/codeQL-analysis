import java.io.*;
import java.net.*;

public class java_38179_SocketServer_A07 {

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(4444);
        System.out.println("Server is listening on port 4444");

        while (true) {
            Socket client = server.accept();
            System.out.println("Client " + client.getRemoteSocketAddress() + " connected");

            DataInputStream in = new DataInputStream(client.getInputStream());
            DataOutputStream out = new DataOutputStream(client.getOutputStream());

            // Read the username from the client
            String username = in.readUTF();
            System.out.println("Received username: " + username);

            // Authenticate the username
            if (authenticate(username)) {
                out.writeUTF("Authentication successful");
            } else {
                out.writeUTF("Authentication failed");
           
                // Close the connection
                client.close();
                continue;
            }

            // If authentication is successful, then start sending messages
            out.writeUTF("Enter your message:");
            String message = in.readUTF();
            System.out.println("Received message: " + message);
            out.writeUTF(message);
            out.flush();

            client.close();
        }
    }

    private static boolean authenticate(String username) {
        // Implement authentication logic here. This is a simplistic example and might not work for your use case.
        // This is just for testing purposes
        return username.equals("admin");
    }
}