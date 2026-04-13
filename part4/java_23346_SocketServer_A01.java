import java.io.*;
import java.net.*;

public class java_23346_SocketServer_A01 {

    public static void main(String[] args) {
        int port = 12345;
        ServerSocket server = null;
        Socket client = null;

        try {
            // Step 1: Initialize the server socket
            server = new ServerSocket(port);
            System.out.println("Server started on port: " + port);

            // Step 2: Accept client connection
            client = server.accept();
            System.out.println("Client connected: " + client.getInetAddress().getHostAddress());

            // Step 3: Initialize input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            DataOutputStream out = new DataOutputStream(client.getOutputStream());

            // Step 4: Read request from client
            String request = in.readLine();
            System.out.println("Received request: " + request);

            // Step 5: Send response to client
            String response = "Server response: " + request;
            out.writeBytes(response + "\n");

            // Step 6: Close connection
            client.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}