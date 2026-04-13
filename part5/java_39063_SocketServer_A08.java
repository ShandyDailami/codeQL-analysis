import java.io.*;
import java.net.*;

public class java_39063_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);

        System.out.println("Server is listening on port 8000");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("A client has connected");

            // Create input and output streams
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            // Receive a message from the client
            String message = input.readUTF();
            System.out.println("Received message: " + message);

            // Send a response back to the client
            output.writeUTF("Hello client, message received successfully");
            output.flush();

            socket.close();
        }
    }
}