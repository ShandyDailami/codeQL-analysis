import java.net.*;
import java.io.*;

public class java_13012_SocketServer_A07 {
    public static void main(String args[]) throws Exception {
        ServerSocket server = new ServerSocket(6000); // Listening port
        while (true) {
            Socket client = server.accept(); // Waiting for client connection
            System.out.println("Connected to the client");

            DataInputStream dis = new DataInputStream(client.getInputStream());
            DataOutputStream dos = new DataOutputStream(client.getOutputStream());

            String message = dis.readUTF(); // Read the message from the client
            System.out.println("Received: " + message);

            dos.writeUTF("Thank you for connecting to " + client.getRemoteSocketAddress()); // Send a response back to the client
            dos.flush();

            client.close();
        }
    }
}