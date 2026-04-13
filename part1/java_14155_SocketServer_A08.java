import java.io.*;
import java.net.*;

public class java_14155_SocketServer_A08 {
    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;

        try {
            server = new ServerSocket(8080); // listen on port 8080
            System.out.println("Waiting for client connection...");

            socket = server.accept(); // wait for client to connect
            System.out.println("Client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF(); // read a message from the client
            System.out.println("Received: " + message);

            String response = "Hello, client!";
            out.writeUTF(response); // send a response back to the client
            System.out.println("Sent: " + response);

            socket.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}