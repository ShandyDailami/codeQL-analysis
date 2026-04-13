import java.io.*;
import java.net.*;
import java.util.*;

public class java_23022_SocketServer_A08 {
    // Server port
    private static final int SERVER_PORT = 12345;
    
    // Server socket
    private ServerSocket serverSocket;
    
    public java_23022_SocketServer_A08() {
        try {
            // Create server socket
            serverSocket = new ServerSocket(SERVER_PORT);
            System.out.println("Server started on port: " + SERVER_PORT);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
    
    public void startServer() {
        while(true) {
            try {
                // Accept a connection
                Socket socket = serverSocket.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());
                
                // Create input and output streams
                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());
                
                // Read the message from the client
                String message = input.readUTF();
                System.out.println("Received: " + message);
                
                // Implement security-sensitive operation related to A08_IntegrityFailure
                // In this example, we'll just reverse the message
                String reversedMessage = new StringBuilder(message).reverse().toString();
                
                // Send the reversed message back to the client
                output.writeUTF(reversedMessage);
                output.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) {
        new A08_IntegrityFailureServer().startServer();
    }
}