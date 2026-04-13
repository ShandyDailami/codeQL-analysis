import java.net.*;
import java.io.*;

public class java_34720_SocketServer_A01 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            // create a ServerSocket and bind it to port 12345
            serverSocket = new ServerSocket(12345);
            System.out.println("Waiting for client connection...");

            // Accept a client socket
            socket = serverSocket.accept();
            System.out.println("Client connected!");

            // Get input and output streams
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Read a string from client
            String message = in.readUTF();
            System.out.println("Received: " + message);

            // Send a response back to client
            out.writeUTF("Hello Client, you connected successfully to port 12345!");
            out.flush();

            // Close the connection
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Close the server socket
            try {
                if (serverSocket != null) serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}