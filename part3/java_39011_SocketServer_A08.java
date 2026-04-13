import java.io.*;
import java.net.*;

public class java_39011_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            // Create a socket server on port 12345
            ServerSocket server = new ServerSocket(12345);
            System.out.println("Server is listening on port 12345");

            while (true) {
                // Wait for a client to connect
                Socket client = server.accept();
                System.out.println("Client connected");

                // Create input and output streams
                DataInputStream in = new DataInputStream(client.getInputStream());
                DataOutputStream out = new DataOutputStream(client.getOutputStream());

                // Read a message from the client
                String message = in.readUTF();
                System.out.println("Received message: " + message);

                // Check if the message is "exit" to terminate the connection
                if (message.equals("exit")) {
                    out.writeUTF("Connection closed");
                    client.close();
                    System.out.println("Connection closed");
                } else {
                    // Generate a response message
                    String response = "Server response: " + message;
                    out.writeUTF(response);
                    out.flush();
                }

                // Close the client's input and output streams
                in.close();
                out.close();
                System.out.println("Connection closed");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}