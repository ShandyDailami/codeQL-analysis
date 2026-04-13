import java.io.*;
import java.net.*;

public class java_36186_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8000); // Listening port
        System.out.println("Server started!");

        while(true) {
            Socket sock = server.accept(); // Waiting for client
            System.out.println("Client connected!");

            // Create InputStream and OutputStream
            BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            DataOutputStream out = new DataOutputStream(sock.getOutputStream());

            // Receive the request from the client
            String request = in.readLine();
            System.out.println("Received: " + request);

            // Send a response back to the client
            out.writeBytes("HTTP/1.1 200 OK\r\n\r\n");
            out.writeBytes("Hello, client!\r\n");

            // Close the connection
            sock.close();
        }
    }
}