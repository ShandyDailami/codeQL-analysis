import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_29786_SocketServer_A07 {
    private static final String AUTH_FAILURE_PROMPT = "Authentication failure";

    public static void main(String[] args) {
        try {
            // Create a server socket and listen on port 12345
            ServerSocket server = new ServerSocket(12345);
            System.out.println("Server is listening on port 12345");

            while (true) {
                // Wait for a client to connect
                Socket client = server.accept();
                System.out.println("Client connected from " + client.getRemoteSocketAddress());

                // Create a new thread for handling the client
                ClientHandler handler = new ClientHandler(client);
                Thread thread = new Thread(handler);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket client;

        public java_29786_SocketServer_A07(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            // Handle the client's input and output
            // For simplicity, we will assume that authentication is successful
            try {
                AuthHandler authHandler = new AuthHandler();
                authHandler.handle(client.getInputStream(), client.getOutputStream(), AUTH_FAILURE_PROMPT);
                System.out.println("Authentication successful");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static class AuthHandler {
        public void handle(InputStream in, OutputStream out, String authFailurePrompt) throws IOException {
            // Read the authentication prompt from the client
            byte[] buffer = new byte[1024];
            int bytesRead = in.read(buffer);
            String authPrompt = new String(buffer, 0, bytesRead);

            // Write the authentication failure prompt back to the client
            out.write(authFailurePrompt.getBytes());
            out.flush();

            // If the authentication fails, close the connection
            if (authFailurePrompt.equals("Authentication failure")) {
                client.close();
            }
        }
    }
}