import java.io.*;
import java.net.*;

public class java_33715_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Waiting for connection on port 8080...");
        
        Socket socket = server.accept();
        System.out.println("Connection established with " + socket.getRemoteSocketAddress());

        // Create streams for reading and writing
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        // Read request from client
        String request = in.readUTF();
        System.out.println("Received request: " + request);

        // Send response to client
        String response = "Hello " + request;
        out.writeUTF(response);
        System.out.println("Sent response: " + response);

        // Close streams and socket
        out.close();
        in.close();
        socket.close();
        server.close();
    }
}