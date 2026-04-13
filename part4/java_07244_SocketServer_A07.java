import java.net.*;
import java.io.*;

public class java_07244_SocketServer_A07 {

    private static final String AUTHENTICATED_USER = "Authenticated user";
    private static final String ERROR_MESSAGE = "Auth failed!";

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8189);
        System.out.println("Server is listening on port 8189");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected");

            // Start a new thread to handle communication with this client
            new EchoHandler(socket).start();
        }
    }

    private static class EchoHandler extends Thread {
        private final Socket socket;

        EchoHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

                // Authenticate the client
                if (!authenticateClient(in)) {
                    out.println(ERROR_MESSAGE);
                    return;
                }

                // Send a message back to the client
                out.println(AUTHENTICATED_USER);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private boolean authenticateClient(BufferedReader in) throws IOException {
            // Authentication logic here. This is a placeholder for the actual implementation.
            return true; // for now, let the client pass the authentication
        }
    }
}