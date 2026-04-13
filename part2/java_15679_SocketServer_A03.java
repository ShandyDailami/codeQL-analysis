import java.io.*;
import java.net.*;

public class java_15679_SocketServer_A03 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            // Create a server socket at port 1234
            serverSocket = new ServerSocket(1234);
            System.out.println("Server is listening on port 1234");

            // Accept client connection
            socket = serverSocket.accept();
            System.out.println("Client connected!");

            // Create an input stream and output stream for communication
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Handle communication
            String message = in.readUTF();
            System.out.println("Received: " + message);

            // Send a response
            out.writeUTF("Thank you for connecting to the server!");
            System.out.println("Sent: Thank you for connecting to the server!");

            // Close the connection
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}