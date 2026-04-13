import java.net.*;
import java.io.*;

public class java_26396_SocketServer_A01 {
    public static void main(String[] args) {
        Socket socket;
        ServerSocket server;

        try {
            // Initialize ServerSocket on port 8189
            server = new ServerSocket(8189);
            System.out.println("Server Started.");

            // Wait for connection
            socket = server.accept();
            System.out.println("Client Connected.");

            // Create stream for communication
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Send message to client
            out.println("Hello Client, Welcome to Socket Programming.");

            // Close stream and socket
            in.close();
            out.close();
            socket.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
       
        }
    }
}