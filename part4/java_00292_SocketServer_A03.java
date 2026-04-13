import java.io.*;
import java.net.*;

public class java_00292_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080); // Listening port
        System.out.println("Server is listening on port 8080");

        while (true) {
            Socket client = server.accept(); // Waiting for a client connection
            System.out.println("A client has connected");

            // Authenticating the client
            DataInputStream in = new DataInputStream(client.getInputStream());
            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            String username = in.readUTF(); // Read the username from the client
            String password = in.readUTF(); // Read the password from the client

            if (authenticate(username, password)) {
                out.writeUTF("Authentication successful");
            } else {
                out.writeUTF("Authentication failed");
           
            }
            client.close(); // Close the connection
        }
    }

    private static boolean authenticate(String username, String password) {
        // Here you would typically connect to a database and check the username and password against the database.
        // For the sake of this example, we'll just return true or false for now.
        return true;
    }
}