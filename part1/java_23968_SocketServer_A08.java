import java.io.*;
import java.net.*;

public class java_23968_SocketServer_A08 {
    public static void main(String args[]) {
        ServerSocket server = null;
        Socket socket = null;

        try {
            // Create a ServerSocket and bind it to a port
            server = new ServerSocket(8080);
            System.out.println("Waiting for client connection...");

            // Wait for a client to connect
            socket = server.accept();
            System.out.println("Connected with client");

            // Create an InputStream and OutputStream
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // Send a message to the client
            dos.writeUTF("Hello Client, Welcome to Socket Programming.");

            // Receive a message from the client
            String message = dis.readUTF();
            System.out.println("Message received from client: " + message);

            // Close the streams and socket
            dos.close();
            dis.close();
            socket.close();
            server.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}