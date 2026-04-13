import java.net.*;
import java.io.*;

public class java_24258_SocketServer_A01 {

    public static void main(String[] args) throws IOException {

        // Create a server socket
        ServerSocket server = new ServerSocket(8080);

        while (true) {

            // Wait for a client to connect
            Socket socket = server.accept();

            // Get the input and output streams
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Get the client's IP address
            InetAddress clientAddress = socket.getInetAddress();
            System.out.println("Client IP address: " + clientAddress.getHostAddress());

            // Send a welcome message to the client
            out.writeBytes("Welcome to the server!\r\n");

            // Close the socket
            socket.close();
        }
    }
}