import java.io.*;
import java.net.*;

public class java_32196_SocketServer_A01 {
    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;

        try {
            server = new ServerSocket(4444); // Port number
            System.out.println("Server is listening on port 4444");

            while (true) {
                socket = server.accept();
                System.out.println("Client connected");

                // Send a message back to the client
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                out.println("Hello Client, You are connected to the server");

                // Close the socket
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Close the server socket
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}