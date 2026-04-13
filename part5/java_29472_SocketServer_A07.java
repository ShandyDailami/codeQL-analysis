import java.io.*;
import java.net.*;

public class java_29472_SocketServer_A07 {
    public static void main(String[] args) {
        int port = 8080; // The port to listen on
        try {
            ServerSocket server = new ServerSocket(port);
            while (true) {
                Socket client = server.accept(); // Waits for a client to connect
                System.out.println("Client connected: " + client.getInetAddress().getHostAddress());

                DataInputStream input = new DataInputStream(client.getInputStream());
                DataOutputStream output = new DataOutputStream(client.getOutputStream());

                // Send a message back to the client
                String message = "Hello client, I have received your message!";
                output.writeUTF(message);
                output.flush();

                // Close the streams
                input.close();
                output.close();

                client.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}