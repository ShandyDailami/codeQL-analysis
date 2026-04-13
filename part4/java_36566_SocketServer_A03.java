import java.io.*;
import java.net.*;

public class java_36566_SocketServer_A03 {

    public static void main(String[] args) {
        int port = 6000;

        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("Server started at port " + port);

            while (true) {
                Socket socket = server.accept();
                System.out.println("A client connected");

                // Create input and output streams
                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());

                // Receive request from client
                String request = input.readUTF();
                System.out.println("Received request: " + request);

                // Process the request (security sensitive operation)
                String response = processRequest(request);

                // Send response to client
                output.writeUTF(response);
                System.out.println("Sent response: " + response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String processRequest(String request) {
        // This is a placeholder for the security sensitive operation,
        // which is not a real use case in this problem, but it's a
        // placeholder to show how you might handle this situation.

        // For simplicity, let's just reverse the request
        String response = new StringBuilder(request).reverse().toString();
        return response;
    }
}