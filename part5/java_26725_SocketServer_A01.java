import java.io.*;
import java.net.*;

public class java_26725_SocketServer_A01 {

    public static void main(String[] args) {
        // Create a server socket
        try (ServerSocket server = new ServerSocket(8080)) {
            System.out.println("Server started, waiting for clients...");

            while (true) {
                try (Socket client = server.accept()) {
                    System.out.println("Client accepted from " + client.getRemoteSocketAddress());

                    // Create input and output streams
                    DataInputStream in = new DataInputStream(client.getInputStream());
                    DataOutputStream out = new DataOutputStream(client.getOutputStream());

                    // Read the message from the client
                    String message = in.readUTF();
                    System.out.println("Received message: " + message);

                    // Echo the message back to the client
                    out.writeUTF("Echo: " + message);
                    out.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}