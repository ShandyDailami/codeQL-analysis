import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_09430_SocketServer_A03 {
    public static void main(String[] args) {
        // Create a new SocketServer at port 12345
        try (ServerSocket server = new ServerSocket(12345)) {
            System.out.println("Server is listening on port 12345");

            while (true) {
                // Accept a new client connection
                try (Socket client = server.accept()) {
                    System.out.println("New client connected: " + client.getRemoteSocketAddress());

                    // Create input and output streams
                    try (BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                         PrintWriter out = new PrintWriter(client.getOutputStream(), true)) {

                        // Receive and echo message from client
                        String message = in.readLine();
                        System.out.println("Received: " + message);

                        // Echo back to client
                        out.println("Echo: " + message);

                        // Flush output stream
                        out.flush();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}