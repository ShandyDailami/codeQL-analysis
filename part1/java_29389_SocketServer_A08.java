import java.net.*;
import java.io.*;

public class java_29389_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080); // listen on port 8080

        while (true) {
            Socket client = server.accept(); // wait for a client to connect

            System.out.println("Accepted connection from " + client.getRemoteSocketAddress());

            OutputStream out = new PrintWriter(client.getOutputStream(), true);
            out.println("Hello, Client!");

            client.close();
        }
    }
}