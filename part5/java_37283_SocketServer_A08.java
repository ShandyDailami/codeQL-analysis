import java.io.*;
import java.net.*;
import java.util.*;

public class java_37283_SocketServer_A08 {
    private static boolean running = true;

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);

        while (running) {
            Socket socket = server.accept();

            // Create input and output streams
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Handle each client connection separately
            out.println("Connected to: " + socket.getRemoteSocketAddress());

            String request, response;
            while ((request = in.readLine()) != null) {
                out.println("Echo: " + request);

                // Implement security-sensitive operations related to A08_IntegrityFailure
                if (request.equalsIgnoreCase("fail")) {
                    throw new RuntimeException("Security Failure");
                }
            }
        }

        // Close the server socket
        server.close();
    }
}