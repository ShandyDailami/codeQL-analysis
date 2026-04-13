import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_21463_SocketServer_A07 {
    private static final int PORT = 4567;

    public static void main(String[] args) {
        ServerSocket server = null;
        Socket client = null;
        try {
            // Create a server socket
            server = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            // Wait for client connection
            client = server.accept();
            System.out.println("Client connected");

            // Create input and output stream
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);

            // Handle client's message
            String request;
            while ((request = in.readLine()) != null) {
                System.out.println("Received: " + request);
                // Check if the request is authentication related
                if (request.contains("A07_AuthFailure")) {
                    // If it is, return an error message
                    out.println("Error: Authentication failure!");
                } else {
                    // If not, return a response message
                    out.println("Server: A07_AuthFailure detected!");
                }
                out.flush();
            }

            // Close connection
            client.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}