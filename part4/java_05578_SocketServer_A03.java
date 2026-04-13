import java.net.*;
import java.io.*;

public class java_05578_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // Create input and output streams
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Get the request from the client
            String request = in.readUTF();
            System.out.println("Received request: " + request);

            // Send a response
            String response = "Hello, client!";
            out.writeUTF(response);
            out.flush();

            // Close the connection
            socket.close();
        }
    }
}