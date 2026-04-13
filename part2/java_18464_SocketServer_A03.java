import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_18464_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080...");

        while (true) {
            Socket socket = server.accept();
            System.out.println("A new client has connected");

            // Create input and output stream for the socket
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Read the client's message
            String message = in.readLine();
            System.out.println("Client says: " + message);

            // Check for injection attempts
            if (isInjectionAttempt(message)) {
                System.out.println("Injection attempt detected. Refusing connection.");
                out.println("Injection attempt detected. Refusing connection.");
            } else {
                out.println("Server says: " + message);
            }

            // Close the socket
            socket.close();
        }
    }

    // This is a simple example of how a client might send a message
    private static boolean isInjectionAttempt(String message) {
        // This is a simple example of a possible injection attempt.
        // In reality, you would likely use a more complex technique to check for injection attacks.
        return message.contains("DROP TABLE");
    }
}