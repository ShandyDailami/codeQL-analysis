import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_24410_SocketServer_A07 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // Start a new thread to handle the communication with the client
            new ClientHandler(socket).start();
        }
    }

    static class ClientHandler extends Thread {
        private Socket socket;

        public java_24410_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                // Read the request from the client
                byte[] request = socket.getInputStream().readAllBytes();
                String requestString = new String(request);

                // Process the request (e.g., authentication)
                boolean isValid = validateRequest(requestString);

                // Send the response back to the client
                byte[] response = (isValid ? "OK" : "Failed").getBytes();
                socket.getOutputStream().write(response);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private boolean validateRequest(String request) {
            // TODO: Implement your authentication logic here
            // This is just a placeholder, replace with your actual authentication logic
            return request.equals("valid_request");
        }
    }
}