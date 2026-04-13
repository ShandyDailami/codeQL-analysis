import java.io.*;
import java.net.*;

public class java_10391_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Server is listening on port 5000...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("A client has connected");

            // Create input and output streams
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            // Read request from client
            String request = input.readUTF();
            System.out.println("Received: " + request);

            // Send response back to client
            String response = "Hello, client!";
            output.writeUTF(response);

            // Close the connection
            socket.close();
        }
    }
}