import java.io.*;
import java.net.*;

public class java_16131_SocketServer_A08 {

    public static void main(String[] args) throws IOException {
        // Check if user provides host and port
        if(args.length != 2) {
            System.out.println("Usage: SocketServer <host> <port>");
            System.exit(1);
        }

        String host = args[0];
        int port = Integer.parseInt(args[1]);

        // Create a socket and bind it to a port
        ServerSocket server = new ServerSocket();
        server.bind(new InetSocketAddress(host, port));

        System.out.println("Server started on port " + port);

        // Listen for client connections
        while(true) {
            Socket client = server.accept();
            System.out.println("Client connected from " + client.getRemoteSocketAddress());

            // Create a writer for the client
            DataOutputStream out = new DataOutputStream(client.getOutputStream());

            // Send a greeting message to the client
            out.writeUTF("Hello, client!");
            out.flush();
        }
    }
}