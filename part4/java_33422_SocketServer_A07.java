import java.io.*;
import java.net.*;

public class java_33422_SocketServer_A07 {

    // Define the port on which the server will operate
    private static final int PORT = 1234;

    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;

        try {
            // Create a server socket
            server = new ServerSocket(PORT);
            System.out.println("Server is listening on port: " + PORT);

            // Wait for client to connect
            socket = server.accept();
            System.out.println("Client connected!");

            // Create input and output streams
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Handle client input
            String request;
            while ((request = in.readLine()) != null) {
                System.out.println("Received request: " + request);
                if ("auth".equals(request)) {
                    out.println("200 OK");
                } else {
                    out.println("401 Unauthorized");
                }
            }

            // Close the resources
            in.close();
            out.close();
            socket.close();
            server.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}