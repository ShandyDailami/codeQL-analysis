import java.io.*;
import java.net.*;
import java.util.*;

public class java_28655_SocketServer_A07 {
    private static final String SERVER_NAME = "SecureServer";
    private static final int SERVER_PORT = 8000;

    public static void main(String[] args) {
        try {
            // Create a new SecurityManager that will be used to enforce
            // our policy on access to our server and the network.
            SecurityManager sm = new SecurityManager();
            ServerSocket server = new ServerSocket(SERVER_PORT, 100, sm);
            System.out.println("Server is ready...");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Connection established from " + socket.getRemoteSocketAddress());

                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());

                // Start the protocol:
                String request = input.readUTF();
                System.out.println("Received: " + request);

                // Send a response:
                String response = "Hello, Client!";
                output.writeUTF(response);
                output.flush();
                System.out.println("Sent: " + response);

                socket.close();
            }
        } catch (IOException ex) {
            System.out.println("Exception caught: " + ex);
        }
    }
}