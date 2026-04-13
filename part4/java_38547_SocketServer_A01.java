import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_38547_SocketServer_A01 {

    private static final int PORT = 12345;

    public static void main(String[] args) throws Exception {
        System.out.println("Server is running...");

        // Create a server socket
        try (Socket socket = new Socket("localhost", PORT)) {
            // Create input and output streams
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {

                // Read the client message
                String clientMessage = reader.readLine();
                System.out.println("Client says: " + clientMessage);

                // Send a response back to the client
                String response = "Hello, client, thanks for connecting!";
                writer.println(response);
                writer.flush();
            }
        }
    }
}