import java.io.*;
import java.net.*;

public class java_34534_SocketServer_A07 {
    public static void main(String[] args) {
        try {
            // Create a server socket and bind it to port 12345
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Server is listening on port 12345");

            while (true) {
                // Accept a client connection
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // Create an input stream and output stream
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                // Send a greeting message to the client
                String message = "Hello, client!";
                dos.writeUTF(message);
                System.out.println("Server sent: " + message);

                // Close the connection
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}