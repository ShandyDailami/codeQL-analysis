import java.io.*;
import java.net.*;

public class java_35313_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(4444); // listen on port 4444
        System.out.println("Server is listening on port 4444");

        while (true) {
            Socket client = server.accept(); // wait for a client connection
            System.out.println("New client connected");

            // send response to the client
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            out.println("Thank you for connecting to our server!");
        }
    }
}