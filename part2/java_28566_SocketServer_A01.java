import java.io.*;
import java.net.*;

public class java_28566_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8080);
            System.out.println("Server is listening on port 8080");

            while (true) {
                Socket socket = server.accept();
                System.out.println("A client has connected!");

                // Create output stream to send a response to the client
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                // Send response to the client
                out.println("Hello, client!");

                // Close the connection
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}