import java.io.*;
import java.net.*;

public class java_07958_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            // Create a server socket and listen on port 1234
            ServerSocket server = new ServerSocket(1234);

            System.out.println("Waiting for a client to connect...");

            // Wait for a client to connect
            Socket client = server.accept();

            System.out.println("Connected to the client!");

            // Create an input stream and output stream
            DataInputStream dis = new DataInputStream(client.getInputStream());
            DataOutputStream dos = new DataOutputStream(client.getOutputStream());

            // Read the client's message
            String clientMessage = dis.readUTF();

            // Send a response back to the client
            dos.writeUTF("Server: Hello, Client!" + clientMessage);
            dos.flush();

            // Close the connections
            client.close();
            server.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}