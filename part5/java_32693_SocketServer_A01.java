import java.io.*;
import java.net.*;

public class java_32693_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080); // listen on port 8080
        System.out.println("Server started on port 8080.");

        while (true) {
            Socket client = server.accept(); // accept a client connection
            System.out.println("Client connected from " + client.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(client.getInputStream());
            DataOutputStream out = new DataOutputStream(client.getOutputStream());

            String request = in.readUTF(); // read a request from the client
            System.out.println("Received request: " + request);

            // Perform security sensitive operations here (e.g., broken access control)

            // Prepare a response
            String response = "Hello, " + request + "!";

            // Write the response back to the client
            out.writeUTF(response);
            out.flush();

            client.close(); // close the connection
        }
    }
}