import java.io.*;
import java.net.*;

public class java_19119_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("A client has connected...");

            // Create input and output streams
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            // Handle each request from client
            String request = input.readUTF();
            System.out.println("Received: " + request);

            // Send response
            String response = "Hello, client!";
            output.writeUTF(response);

            // Close the connection
            socket.close();
        }
    }
}