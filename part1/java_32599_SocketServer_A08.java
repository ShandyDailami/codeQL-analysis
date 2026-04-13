import java.io.*;
import java.net.*;

public class java_32599_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            // Read the message from the client
            String message = input.readUTF();
            System.out.println("Received: " + message);

            // Send the message back to the client
            output.writeUTF(message);
            output.flush();
            System.out.println("Sent: " + message);

            socket.close();
        }
    }
}