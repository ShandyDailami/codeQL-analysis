import java.io.*;
import java.net.*;

public class java_23851_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);

        while (true) {
            Socket socket = server.accept();

            // Create input stream and output stream
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Read request
            String request = in.readLine();
            System.out.println("Received: " + request);

            // Send response
            out.writeBytes("HTTP/1.1 200 OK\n\n" + request + "\n");

            // Close the connection
            socket.close();
        }
    }
}