import java.net.*;
import java.io.*;

public class java_10715_SocketServer_A03 {

    public static void main(String[] args) {
        Socket socket = null;

        try {
            // Create a server socket with specified port number
            ServerSocket serverSocket = new ServerSocket(6000);
            System.out.println("Waiting for client on port: " + serverSocket.getLocalPort() + "... ");

            // Accept a client socket
            socket = serverSocket.accept();
            System.out.println("Client has connected!");

            // Create a new input stream from the socket input stream
            DataInputStream in = new DataInputStream(socket.getInputStream());

            // Read a message from the client
            String message = in.readUTF();
            System.out.println("Client says: " + message);

            // Send a message back to the client
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF("Hello client, your data has been received");
            System.out.println("Server says: Hello client, your data has been received");

            // Close the connection
            socket.close();

        } catch (Exception e) {
            socket.close();
            System.out.println(e.getMessage());
        }
    }
}