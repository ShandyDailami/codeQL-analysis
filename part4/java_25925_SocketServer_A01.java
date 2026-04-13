import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;

public class java_25925_SocketServer_A01 {
    private static final Logger logger = Logger.getLogger(SocketServer.class.getName());

    public static void main(String[] args) throws Exception {
        int port = 1234;

        try (ServerSocket serverSocket = new ServerSocket(port);
             Socket clientSocket = serverSocket.accept();
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             OutputStream out = clientSocket.getOutputStream()) {

            String request;
            while ((request = in.readLine()) != null) {
                logger.info("Received request: " + request);

                // Simulate a security-sensitive operation related to A01_BrokenAccessControl
                // In a real-world scenario, this operation would involve access control, error handling, etc.
                if ("BREAK".equals(request)) {
                    // Break the connection for demonstrating A01_BrokenAccessControl
                    clientSocket.close();
                    logger.warning("Break access control violation!");
                    continue;
                }

                // Simulate a response
                String response = "Hello, client!";
                out.write(response.getBytes());
                out.newLine();
                out.flush();
            }
        } catch (Exception e) {
            logger.severe("Exception occurred: " + e);
        }
    }
}