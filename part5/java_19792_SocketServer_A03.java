import java.net.*;
import java.io.*;

public class java_19792_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6000);
        System.out.println("Server started!");

        while (true) {
            Socket socket = serverSocket.accept();

            System.out.println("New client connected!");

            // Create input and output streams
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

            // Send a welcome message
            outputStream.writeUTF("Welcome to the server!");

            // Receive a message from client
            String message = inputStream.readUTF();
            System.out.println("Received message from client: " + message);

            // Close the connection
            socket.close();
       
        }
    }
}