import java.io.*;
import java.net.*;

public class java_40896_SocketServer_A03 {

    // The main server program
    public static void main(String[] args) throws Exception {
        int port = 8080;
        ServerSocket server = new ServerSocket(port);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            // Create stream for reading and writing
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Read data from client
            String request = in.readUTF();
            System.out.println("Received request: " + request);

            // Process the request (for example, logging it)
            System.out.println("Processing request...");

            // Send response back to client
            String response = "Success!";
            out.writeUTF(response);
            System.out.println("Sent response: " + response);
       
            socket.close();
        }
    }
}