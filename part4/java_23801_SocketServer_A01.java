import java.io.*;
import java.net.*;

public class java_23801_SocketServer_A01 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            // Create a server socket at port 8080
            serverSocket = new ServerSocket(8080);
            System.out.println("Server is listening on port 8080");

            // Wait for a client to connect
            socket = serverSocket.accept();
            System.out.println("Client connected");

            // Send a response to the client
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            outputStream.writeUTF("Hello, client!");
            System.out.println("Message sent to client");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try { socket.close(); } catch (IOException e) { /* can't do anything */ }
            }
            if (serverSocket != null) {
                try { serverSocket.close(); } catch (IOException e) { /* can't do anything */ }
            }
        }
    }
}