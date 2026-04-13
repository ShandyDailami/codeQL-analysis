import java.io.*;
import java.net.*;

public class java_13613_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(12345); // listen on port 12345
        System.out.println("Server started on port 12345");

        while (true) {
            Socket socket = server.accept(); // accept a client connection
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF("Welcome to the server!"); // send a welcome message

            DataInputStream in = new DataInputStream(socket.getInputStream());
            String message = in.readUTF(); // receive a command from the client
            System.out.println("Received: " + message);

            out.writeUTF("Thank you for connecting!"); // send a response
            socket.close(); // remember to close the connection
        }
    }
}