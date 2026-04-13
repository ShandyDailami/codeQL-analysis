import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Logger;

public class java_37047_SocketServer_A07 {
    private static final Logger logger = Logger.getLogger(SocketServer.class.getName());

    public static void main(String[] args) {
        int port = 5555;
        try (ServerSocket server = new ServerSocket(port)) {
            logger.info("Server started on port " + port);

            while (true) {
                try (Socket client = server.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                     PrintWriter out = new PrintWriter(client.getOutputStream(), true)) {
                    String request = in.readLine();
                    logger.info("Received: " + request);

                    // Security sensitive operation: Authentication
                    if (!authenticateUser(request)) {
                        out.println("Authentication failed");
                        continue;
                    }

                    out.println("Hello, client!");
                } catch (Exception e) {
                    logger.severe("Exception occurred: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            logger.severe("Exception occurred when starting server: " + e.getMessage());
        }
    }

    private static boolean authenticateUser(String request) {
        // Placeholder for security sensitive operation: Implement authentication logic here
        // You should compare the request with a securely stored hash or other form of authentication method
        return true;
    }
}