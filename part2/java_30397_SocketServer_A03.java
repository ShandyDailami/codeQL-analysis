import java.io.*;
import java.net.*;

public class java_30397_SocketServer_A03 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            // Create a server socket and bind it to a port
            serverSocket = new ServerSocket(5000);
            System.out.println("Server is listening on port 5000");

            // Wait for a client to connect
            socket = serverSocket.accept();
            System.out.println("Client connected");

            // Create input and output streams
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Receive a message from the client
            String message = in.readUTF();
            System.out.println("Received: " + message);

            // Echo the received message back to the client
            out.writeUTF("Echo: " + message);
            out.flush();

            // Close the connection
            socket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}