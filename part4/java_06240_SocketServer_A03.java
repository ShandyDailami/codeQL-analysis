import java.io.*;
import java.net.*;

public class java_06240_SocketServer_A03 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started on port 8080...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected");

            // Create input and output streams
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Get request from client
            String request = in.readUTF();
            System.out.println("Received request: " + request);

            // Process request
            String response = processRequest(request);

            // Send response to client
            out.writeUTF(response);
            out.flush();

            socket.close();
        }
    }

    private static String processRequest(String request) {
        // Simulate a security-sensitive operation
        // Inject malicious code into the request
        String injectedRequest = request + "<script>alert('Injection!')</script>";
        return injectedRequest;
    }
}