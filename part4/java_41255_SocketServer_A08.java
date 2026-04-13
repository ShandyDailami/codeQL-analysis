import java.io.*;
import java.net.*;

public class java_41255_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server is running and waiting for a client to connect...");
        
        while (true) {
            Socket socket = server.accept();
            System.out.println("A client has connected!");
            
            // Send the response to the client
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF("Thank you for connecting to " + socket.getLocalSocketAddress() + "\n");
            
            // Close the connection
            socket.close();
        }
    }
}