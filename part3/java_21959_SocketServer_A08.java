import java.io.*;
import java.net.*;

public class java_21959_SocketServer_A08 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            // Create a ServerSocket and wait for a connection
            serverSocket = new ServerSocket(8080);
            System.out.println("Waiting for a client...");
            socket = serverSocket.accept();
            System.out.println("Client connected");

            // Send a response to the client
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF("Hello Client, I am a SocketServer");

            // Close the connection
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}