import java.io.*;
import java.net.*;

public class java_03824_SocketServer_A03 {

    // Start the server
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(6000);
            System.out.println("Server is running...");

            while (true) {
                Socket client = server.accept();
                System.out.println("A new client has connected...");

                // Create input stream and output stream
                DataInputStream dis = new DataInputStream(client.getInputStream());
                DataOutputStream dos = new DataOutputStream(client.getOutputStream());

                // Receive request from the client
                String request = dis.readUTF();
                System.out.println("Received request: " + request);

                // Send response to the client
                String response = processRequest(request);
                dos.writeUTF(response);
                dos.close();

                System.out.println("Sent response: " + response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Process the request
    private static String processRequest(String request) {
        // You can put any security-sensitive operation here like sanitize inputs,
        // validate inputs, hash inputs, etc.

        // This is a dummy operation for demonstration
        String response = "Server received: " + request;
        return response;
    }
}