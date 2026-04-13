import java.io.*;
import java.net.*;

public class java_34407_SocketServer_A01 {
    private static final int port = 12345;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(port);
        System.out.println("Server started on port: " + port);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected: " + socket.getRemoteSocketAddress());

            // Create input and output streams
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Read the request from the client
            String request = in.readUTF();
            System.out.println("Received: " + request);

            // Handle the request (here, we simply echo it back)
            String response = "ECHO: " + request;
            out.writeUTF(response);

            // Close the connection
            socket.close();
       
        }
    }
}