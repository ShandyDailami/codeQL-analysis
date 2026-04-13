import java.io.*;
import java.net.*;

public class java_26126_SocketServer_A08 {
    private static int port = 8080;

    public static void main(String[] args) {
        try {
            // Step 1: Create a server socket
            ServerSocket server = new ServerSocket(port);
            System.out.println("Server is listening on port: " + port);

            // Step 2: Accept a client connection
            Socket client = server.accept();
            System.out.println("A client has connected!");

            // Step 3: Send a response to the client
            DataOutputStream output = new DataOutputStream(client.getOutputStream());
            output.writeUTF("Hello Client, Connection Established!");

            // Close the connection
            client.close();
            server.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}