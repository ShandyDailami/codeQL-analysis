import java.io.*;
import java.net.*;

public class java_30523_SocketServer_A03 {

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);
        while (true) {
            Socket socket = server.accept();
            new Handler(socket).start();
        }
    }

    static class Handler extends Thread {
        Socket socket;
        BufferedReader reader;
        PrintWriter writer;

        public java_30523_SocketServer_A03(Socket socket) {
            this.socket = socket;
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);
        }

        public void run() {
            try {
                String clientMessage;
                while ((clientMessage = reader.readLine()) != null) {
                    processInput(clientMessage);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                socket.close();
            }
        }

        private void processInput(String clientMessage) {
            // In the context of security sensitive operations, you might want to consider:
            // 1. Removing or replacing user-submitted input.
            // 2. Applying security measures like input/output streams encryption/decryption.
            // 3. Sanitizing clientMessage, such as by replacing or removing characters that are not allowed in a Java identifier.
            // 4. Checking if the clientMessage matches a specific pattern or format that the server expects.
            // Here's a simple example:
            String sanitizedMessage = clientMessage.replaceAll("[^a-zA-Z0-9]", "");
            writer.println("Server says: " + sanitizedMessage);
        }
    }
}