import java.io.*;
import java.net.*;

public class java_10741_SocketServer_A07 {
    private static int port = 12345;
    private static ServerSocket server;
    
    public static void main(String[] args) {
        try {
            server = new ServerSocket(port);
            System.out.println("Server is listening on port: " + port);
            
            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());
                
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                
                String message = in.readUTF();
                System.out.println("Received: " + message);
                
                // Implement your security-sensitive operations here, for example:
                if ("A07_AuthFailure".equals(message)) {
                    out.writeUTF("Authentication failed");
                } else {
                    out.writeUTF("Unknown message");
                }
                
                out.flush();
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (server != null) server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}