import java.io.*;
import java.net.*;

public class java_30204_SocketServer_A01 {

    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started on port: " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected: " + socket.getRemoteSocketAddress());

            // Create streams for input and output
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String request = in.readLine();
            System.out.println("Received request: " + request);

            // Handle request
            if ("ACCESS_DENIED".equals(request)) {
                out.writeBytes("Access denied\n");
            } else {
                out.writeBytes("Access granted\n");
           
                // Assume the client is authenticated and we allow them to proceed
                // Replace this with a secure authentication process if required
            }

            // Close streams
            out.close();
            socket.close();
        }
    }
}