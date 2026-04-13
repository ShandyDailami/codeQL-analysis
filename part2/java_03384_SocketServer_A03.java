import java.io.*;
import java.net.*;

public class java_03384_SocketServer_A03 {

    public static void main(String[] args) {

        try {
            // Create a server socket
            ServerSocket server = new ServerSocket(1234);
            System.out.println("Server started on port 1234");

            // Accept client connection
            Socket socket = server.accept();
            System.out.println("Client accepted");

            // Create input and output stream
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            // Read message from client
            String message = input.readUTF();
            System.out.println("Received: " + message);

            // Send message back to client
            output.writeUTF("Hello, client, you are connected to server!");
            output.flush();

            // Close resources
            socket.close();
            server.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}