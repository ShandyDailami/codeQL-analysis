import java.io.*;
import java.net.*;

public class java_31486_SocketServer_A03 {

    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        while (true) {
            Socket socket = server.accept();

            // Step 1: Create new thread for each client connection
            Thread thread = new ConnectionHandler(socket);
            thread.start();
        }
    }

    // Step 2: Create a thread for each client connection
    private static class ConnectionHandler extends Thread {
        private Socket socket;
        private BufferedReader reader;
        private DataOutputStream writer;

        public java_31486_SocketServer_A03(Socket socket) {
            this.socket = socket;
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer = new DataOutputStream(socket.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            try {
                String clientMessage;
                while ((clientMessage = reader.readLine()) != null) {
                    // Step 3: Implement some kind of data sanitization here
                    clientMessage = cleanInput(clientMessage);

                    // Step 4: Send a response back to the client
                    writer.write((clientMessage + "\r\n").getBytes());
                    writer.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                socket.close();
            }
        }

        private String cleanInput(String input) {
            // Implement your own security measures here
            // For example, you can replace all non-alphanumeric characters with nothing
            return input.replaceAll("[^a-zA-Z0-9]", "");
        }
    }
}