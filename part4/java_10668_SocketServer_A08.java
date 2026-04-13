import java.io.*;
import java.net.*;

public class java_10668_SocketServer_A08 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            // Create a server socket
            serverSocket = new ServerSocket(1234);
            System.out.println("Server is listening on port 1234...");

            // Accept a client connection
            socket = serverSocket.accept();
            System.out.println("Client connected...");

            // Create input and output streams
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Read the client message
            String message = in.readUTF();
            System.out.println("Received message: " + message);

            // Send back the client message
            out.writeUTF("Your message has been received: " + message);

            // Close the streams and the socket
            in.close();
            out.close();
            socket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}