import java.io.*;
import java.net.*;

public class java_09608_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            // Process incoming request
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

            String request = in.readLine(); // Read incoming request
            System.out.println("Received request: " + request);

            // Cross-site scripting prevention:
            // Replace "bad_input" with the actual input from the client
            String sanitizedRequest = request.replace("bad_input", "<script>alert('Bad Input');</script>");
            System.out.println("Sanitized request: " + sanitizedRequest);

            out.writeBytes("HTTP/1.1 200 OK\r\n\r\n");
            out.writeBytes(sanitizedRequest + "\r\n");

            clientSocket.close();
        }
    }
}