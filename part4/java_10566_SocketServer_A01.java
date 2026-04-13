import java.io.*;
import java.net.*;

public class java_10566_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is running...");
        
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected: " + socket.getRemoteSocketAddress());
            
            // Create input and output streams
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Read request
            String request = in.readUTF();
            System.out.println("Request received: " + request);

            // Send response
            String response = "Hello, client!";
            out.writeUTF(response);
            System.out.println("Response sent: " + response);

            // Close the connection
            socket.close();
        }
    }
}