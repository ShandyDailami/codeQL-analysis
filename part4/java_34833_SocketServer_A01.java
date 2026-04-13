import java.io.*;
import java.net.*;

public class java_34833_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(6000);
        System.out.println("Server started");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // Read the request from the client
            String request = dis.readUTF();
            System.out.println("Received request: " + request);

            // Proxy the request to the server's database
            String response = proxyRequest(request);
            dos.writeUTF(response);

            // Close the connections
            dos.close();
            dis.close();
       
            System.out.println("Sent response: " + response);
            System.out.println("Client disconnected");
        }
    }

    private static String proxyRequest(String request) {
        // This is a placeholder, replace with your actual logic
        return "Server response for: " + request;
    }
}