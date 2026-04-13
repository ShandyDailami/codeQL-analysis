import java.io.*;
import java.net.*;

public class java_23272_SocketServer_A07 {

    public static void main(String[] args) throws Exception {
        // Create socket
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Server started");

        while (true) {
            // Wait for a client to connect
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // Create input and output streams
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // Receive client's message
            String message = dis.readUTF();
            System.out.println("Received: " + message);

            // Send back a message
            String response = "Hello, client";
            dos.writeUTF(response);
            System.out.println("Sent: " + response);

            // Close connection
            socket.close();
        }
    }
}