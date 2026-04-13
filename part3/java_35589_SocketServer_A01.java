import java.io.*;
import java.net.*;

public class java_35589_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(12345);
            System.out.println("Server is listening on port 12345");

            while (true) {
                Socket socket = server.accept();
                System.out.println("A client has connected");

                // Create output stream to send a response back to the client
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                // Send "Hello World" message
                out.println("Hello World");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}