import java.io.*;
import java.net.*;

public class java_33030_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(6000);
        System.out.println("Server started...");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected...");

            // Send a response to the client
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            writer.println("Welcome to the server!");

            // Close the socket here
            // socket.close();
       
            // In a real-world scenario, the server should not close the socket here.
            // Instead, the socket should be used for the purpose of data transmission,
            // and the client should be kept open for more data when necessary.
        }
    }
}