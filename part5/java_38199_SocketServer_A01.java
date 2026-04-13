import java.io.*;
import java.net.*;

public class java_38199_SocketServer_A01 {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1234); // port number
            System.out.println("Waiting for client on port 1234...");

            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            // Create input and output streams
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            // Handle data from client
            String clientMessage = input.readUTF();
            System.out.println("Received message from client: " + clientMessage);

            // Send back a response
            String response = "Server received your message!";
            output.writeUTF(response);

            // Close connections
            socket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}