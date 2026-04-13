import java.io.*;
import java.net.*;

public class java_16949_SocketServer_A07 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            // Create a ServerSocket and listen on port 4444
            serverSocket = new ServerSocket(4444);
            System.out.println("Waiting for client...");

            // Accept a client
            socket = serverSocket.accept();
            System.out.println("Client connected!");

            // Create input and output streams
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Send welcome message to client
            out.writeUTF("Welcome to the server!");
            String message = in.readUTF();
            System.out.println("Message from client: " + message);

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