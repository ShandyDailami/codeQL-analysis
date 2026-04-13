import java.net.ServerSocket;
import java.net.Socket;

public class java_24489_SocketServer_A08 {
    private static final String EXPECTED_PASSWORD = "securePassword";

    public static void main(String[] args) throws Exception {
        // Create a server socket and listen for connections on port 12345
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Server is listening on port 12345");

            while (true) {
                // Wait for a client to connect
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected");

                // Get the input stream from the client
                try (SocketReader socketReader = new SocketReader(clientSocket.getInputStream())) {
                    // Read the password from the client
                    String clientPassword = socketReader.readPassword();

                    // Check if the password matches the expected password
                    if (!clientPassword.equals(EXPECTED_PASSWORD)) {
                        // If not, send an "A08_IntegrityFailure" message to the client
                        try (SocketWriter socketWriter = new SocketWriter(clientSocket.getOutputStream())) {
                            socketWriter.writeMessage("A08_IntegrityFailure");
                        }
                        continue;
                    }

                    // If the password matches, send a welcome message to the client
                    try (SocketWriter socketWriter = new SocketWriter(clientSocket.getOutputStream())) {
                        socketWriter.writeMessage("Welcome, authenticated user!");
                    }
                }
            }
        }
    }
}