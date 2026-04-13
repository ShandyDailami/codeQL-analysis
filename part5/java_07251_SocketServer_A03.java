import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

public class java_07251_SocketServer_A03 {
    private static final Logger logger = Logger.getLogger(SecureSocketServer.class.getName());

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(4444);
        logger.info("Server started on port 4444");

        while (true) {
            Socket socket = serverSocket.accept();
            logger.info("Client connected");

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            String message = input.readUTF();
            logger.info("Received message: " + message);

            // A03_Injection: sanitize and escape user input to prevent injection
            String sanitizedMessage = sanitizeAndEscapeInput(message);

            output.writeUTF("Thanks for the message: " + sanitizedMessage);
            output.flush();
            logger.info("Sent message: " + sanitizedMessage);

            socket.close();
        }
    }

    private static String sanitizeAndEscapeInput(String input) {
        // TODO: Implement the sanitization and escaping logic
        // This is a simple example and may not work in all cases
        return input;
    }
}