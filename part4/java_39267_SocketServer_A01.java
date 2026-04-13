import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_39267_SocketServer_A01 {

    private static final int PORT = 5000; // Port to listen for connections on.

    public static void main(String[] args) {
        System.out.println("Server is starting...");
        try (ServerSocket server = new ServerSocket(PORT)) {
            while (true) {
                Socket clientSocket = server.accept();
                System.out.println("New client connected.");
                new ClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port " + PORT + ".");
            e.printStackTrace();
        }
    }

    private static class ClientHandler extends Thread {
        private final Socket clientSocket;

        public java_39267_SocketServer_A01(Socket socket) {
            this.clientSocket = socket;
        }

        public void run() {
            // Here, we'll be using a very basic form of security to prevent access to sensitive information.
            // In a real-world application, you'd want to use a more secure method of handling connections,
            // such as using SSL or a more secure authentication mechanism.
            try {
                while (true) {
                    // Read a single line of text from the client
                    BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    String message = reader.readLine();
                    System.out.println("Received: " + message);

                    // Reply with a more secure message
                    PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
                    writer.println("Secure message received: " + message);
                }
            } catch (IOException e) {
                System.out.println("Exception caught when trying to read from or write to the socket.");
                e.printStackTrace();
            }
        }
    }
}