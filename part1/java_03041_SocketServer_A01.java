import java.io.*;
import java.net.*;
import java.util.*;

public class java_03041_SocketServer_A01 {
    public static void main(String[] args) {
        ServerSocket server = null;
        Socket client = null;

        try {
            // Step 1: Initialize the Server Socket.
            server = new ServerSocket(6000);

            System.out.println("Server is listening on port 6000");

            // Step 2: Wait for a client to connect.
            client = server.accept();

            System.out.println("Client connected: " + client.getRemoteSocketAddress());

            // Step 3: Get the input and output streams.
            DataInputStream in = new DataInputStream(client.getInputStream());
            DataOutputStream out = new DataOutputStream(client.getOutputStream());

            // Step 4: Send and receive data.
            String data = in.readUTF();
            out.writeUTF("Server received: " + data);

            // Close the connections
            in.close();
            out.close();
            client.close();
            server.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}