import java.net.*;
import java.io.*;

public class java_27522_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080); // Listening port
        System.out.println("Server started on port 8080.");

        while (true) {
            Socket socket = server.accept(); // Accepting client connection
            System.out.println("A client has connected.");

            // Sending a response
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            writer.println("Hello from server!");

            // Close connection
            writer.close();
            socket.close();
        }
    }
}