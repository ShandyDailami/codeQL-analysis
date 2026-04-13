import java.io.*;
import java.net.*;

public class java_24823_SocketServer_A03 {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server started at " + server.getLocalSocketAddress());
        
        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected at " + socket.getRemoteSocketAddress());
            
            // Input validation for localhost connections
            if (!socket.getInetAddress().getHostAddress().equals("127.0.0.1")) {
                System.out.println("Connection from " + socket.getInetAddress().getHostAddress() + " is not allowed!");
                socket.close();
                continue;
            }
            
            // Data I/O
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            
            // Receive a message from the client
            String message = in.readUTF();
            System.out.println("Received: " + message);
            
            // Send a response back to the client
            String response = "Hello, Client!";
            out.writeUTF(response);
            out.flush();
            
            socket.close();
        }
    }
}