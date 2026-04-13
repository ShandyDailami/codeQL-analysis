import java.io.*;
import java.net.*;

public class java_15148_SocketServer_A08 {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080); // Creating a server socket
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = server.accept(); // Listening for incoming connections
            System.out.println("New client connected");

            // Creating input and output streams
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Receiving a message from the client
            String message = in.readUTF();
            System.out.println("Received message: " + message);

            // Sending a response to the client
            String response = "Hello, " + message + "!";
            out.writeUTF(response);

            // Closing the connection
            socket.close();
       
        }
    }
}