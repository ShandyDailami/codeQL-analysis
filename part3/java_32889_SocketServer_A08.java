import java.io.*;
import java.net.*;

public class java_32889_SocketServer_A08 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            // Create a ServerSocket to listen to incoming connections
            serverSocket = new ServerSocket(5000);

            System.out.println("Waiting for client...");

            // Accept a client socket
            socket = serverSocket.accept();
            System.out.println("Connected with IP: " + socket.getInetAddress().getHostAddress());

            // Output stream to send data to the client
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Input stream to receive data from the client
            DataInputStream in = new DataInputStream(socket.getInputStream());

            // Read the message from the client
            String message = in.readUTF();
            System.out.println("Received: " + message);

            // Send a message to the client
            out.writeUTF("Server received your message successfully!");
            System.out.println("Sent: " + out.readUTF());

            // Close the connections
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}