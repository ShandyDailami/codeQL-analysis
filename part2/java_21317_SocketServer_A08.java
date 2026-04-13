import java.io.*;
import java.net.*;

public class java_21317_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server started on port 8080");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // Create input and output streams
                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());

                // Receive the message from client
                String message = input.readUTF();
                System.out.println("Received: " + message);

                // Send back the message to client
                output.writeUTF("Server received your message: " + message);
                output.flush();

                // Close the connection
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}