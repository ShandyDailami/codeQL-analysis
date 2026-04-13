import java.io.*;
import java.net.*;

public class java_22270_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected: " + socket.getRemoteSocketAddress());

            // Create input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Send a welcome message to the client
            out.println("Welcome to the server!");

            // Handle each client's request
            String request;
            while ((request = in.readLine()) != null) {
                System.out.println("Received: " + request);
                if (request.equals("exit")) {
                    break;
                }

                // Bypass the request for security-sensitive operations
                out.println("Received: " + request);
           
                // Send a response back to the client
                out.println("Server response: " + request);
            }

            socket.close();
        }
    }
}