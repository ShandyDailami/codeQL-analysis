import java.io.*;
import java.net.*;

public class java_37917_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        // Create a socket
        ServerSocket serverSocket = new ServerSocket(8080);

        // Listen for connections
        while (true) {
            Socket socket = serverSocket.accept();

            // Print out the client's IP
            System.out.println("Client " + socket.getInetAddress().getHostAddress() + " connected");

            // Create a reader and writer
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Send a message to the client
            out.writeUTF("Welcome to the server!");

            // Close the streams and the socket
            in.close();
            out.close();
            socket.close();
        }
    }
}