import java.io.*;
import java.net.*;

public class java_30837_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            // Create a writer to send a message back to the client
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Send a message back to the client
            out.println("Hello, client!");
       
            // Close the connection
            socket.close();
        }
    }
}