import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class java_12807_SocketServer_A08 {

    private static final Logger logger = Logger.getLogger(SocketServer.class.getName());

    public static void main(String[] args) {
        int port = 12345; // the port number to be used.

        // Create server socket and bind it to port number
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            logger.info("Server is listening on port: " + port);

            while (true) {
                try (Socket socket = serverSocket.accept()) {
                    logger.info("Client connected: " + socket.getRemoteSocketAddress());

                    // Create input and output streams for communication
                    try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                         PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

                        // Create reader and writer for client communication
                        String input;

                        // read from client
                        while ((input = in.readLine()) != null) {
                            logger.info("Received: " + input);

                            // Simulate a security-sensitive operation (IntegrityFailure)
                            if (input.equals("failure")) {
                                throw new SecurityException("Simulated Security Failure");
                            }

                            // Send response to client
                            out.println("Response: " + input);
                        }
                    }
                }
            }
        } catch (IOException | SecurityException ex) {
            logger.log(Level.SEVERE, "Error in server", ex);
        }
    }
}