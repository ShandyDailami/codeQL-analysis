import java.io.*;
import java.net.*;

public class java_14402_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        // Create a new server socket
        ServerSocket serverSocket = new ServerSocket(8080);

        System.out.println("Server is running and waiting for client connections...");

        while (true) {
            // Accept a new client connection
            Socket socket = serverSocket.accept();

            System.out.println("A new client has connected!");

            // Create a new input stream and output stream
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Send a welcome message to the client
            out.writeUTF("Welcome to the server!");

            // Receive a message from the client
            String message = in.readUTF();
            System.out.println("Received message from client: " + message);

            // Close the streams
            in.close();
            out.close();
       
            // Close the socket
            socket.close();
        }
    }
}