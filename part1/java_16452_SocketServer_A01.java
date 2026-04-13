import java.net.*;
import java.io.*;

public class java_16452_SocketServer_A01 {
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        // Create server socket
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(4444);
            System.out.println("Server started on port 4444");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Main loop
        while (true) {
            try {
                // Accept connection
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");
                
                // Get input stream
                DataInputStream in = new DataInputStream(socket.getInputStream());
                
                // Get client's credentials
                String clientUsername = in.readUTF();
                String clientPassword = in.readUTF();
                
                // Check credentials
                if (!clientUsername.equals(USERNAME) || !clientPassword.equals(PASSWORD)) {
                    System.out.println("Invalid credentials");
                    socket.close();
                    continue;
                }
                
                // Write message to client
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                out.writeUTF("Authentication successful");
                
                // Close connection
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}