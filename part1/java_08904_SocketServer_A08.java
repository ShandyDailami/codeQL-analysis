import java.io.*;
import java.net.*;

public class java_08904_SocketServer_A08 {

    public static void main(String[] args) {
        Socket socket;

        try {
            // Create a server socket and listen for connections
            ServerSocket serverSocket = new ServerSocket(4444);

            while (true) {
                System.out.println("Waiting for client on port 4444...");

                // Accept a new connection
                socket = serverSocket.accept();

                System.out.println("Connected to " + socket.getRemoteSocketAddress());

                // Create input and output streams
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                // Send a welcome message to the client
                out.writeUTF("Welcome to the server!");

                // Receive a message from the client
                String message = in.readUTF();
                System.out.println("Received: " + message);

                // Close the connection
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}