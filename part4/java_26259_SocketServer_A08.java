import java.net.*;
import java.io.*;

public class java_26259_SocketServer_A08 {

    public static void main(String[] args) {

        // Step 1: Create a socket
        Socket socket = null;

        try {
            // Create a socket at port 12345
            socket = new Socket("localhost", 12345);

            // Step 2: Create an output stream
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Step 3: Send a message to the client
            out.println("Hello, client!");

            // Close the socket and the streams
            socket.close();
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}