import java.io.*;
import java.net.*;

public class java_10298_SocketServer_A03 {

    private static final int PORT = 8080;

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started.");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected.");

            // Create input and output streams for communication
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Receive the request and send the response
            String request = in.readUTF();
            String response = processRequest(request);
            out.writeUTF(response);

            // Close the connection
            out.close();
            in.close();
            socket.close();

            System.out.println("Client disconnected.");
        }
    }

    private static String processRequest(String request) {
        // Simulate a security-sensitive operation related to injection.
        // Here, we're just echoing back the request as a response.
        return request;
    }
}