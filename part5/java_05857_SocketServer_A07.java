import java.net.*;
import java.io.*;
import java.security.*;

public class java_05857_SocketServer_A07 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");
        
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Accepted connection from " + socket.getRemoteSocketAddress());
            
            // Here, you should implement the security-sensitive operation related to A07_AuthFailure
            // For now, we'll just print a message
            try (OutputStream out = socket.getOutputStream();
                 PrintWriter writer = new PrintWriter(out, true)) {
                writer.println("Hello, client!");
            } catch (IOException e) {
                System.out.println("Failed to send message to client");
            }
        }
    }
}