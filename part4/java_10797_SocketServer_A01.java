import java.io.*;
import java.net.*;

public class java_10797_SocketServer_A01 {
    private static final int PORT = 9000;

    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;

        try {
            // Create a server socket and bind it to a port
            server = new ServerSocket(PORT);
            System.out.println("Server is listening on port: " + PORT);

            // Accept a client connection
            socket = server.accept();

            // Create input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Receive message from client
            String message = in.readLine();
            System.out.println("Client says: " + message);

            // Send response to client
            String response = "Hello, client!";
            out.println(response);

            // Close resources
            socket.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}