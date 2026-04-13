import java.io.*;
import java.net.*;

public class java_21505_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(1234); // listening on port 1234
            System.out.println("Waiting for a client...");

            Socket socket = server.accept(); // accept a client connection
            System.out.println("Client connected!");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Reading from the client
            String message = in.readUTF();
            System.out.println("Received: " + message);

            // Sending a response back to the client
            String response = "Hello, client!";
            out.writeUTF(response);

            // Close the connection
            socket.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}