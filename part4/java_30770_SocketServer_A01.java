import java.io.*;
import java.net.*;

public class java_30770_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5000); // Set port number
            System.out.println("Server started on port 5000");

            while (true) {
                Socket socket = serverSocket.accept(); // Accept client
                System.out.println("Client accepted from " + socket.getRemoteSocketAddress());

                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());

                String message = input.readUTF(); // Read message from client
                System.out.println("Received: " + message);

                output.writeUTF("Server received your message: " + message); // Send response back
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}