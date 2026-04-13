import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_07139_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        int port = 8080;

        System.out.println("Starting Socket Server on port " + port);

        while (true) {
            try (Socket serverSocket = new Socket("localhost", port);
                 PrintWriter out = new PrintWriter(serverSocket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()))) {

                System.out.println("Connected to the client");

                String request;
                while ((request = in.readLine()) != null) {
                    System.out.println("Received request: " + request);

                    // Example of security-sensitive operation: String manipulation
                    // Here, we're simply echoing back the request to the client
                    String response = request;

                    out.println(response);
                }
            }

            // If there's an exception, the client has disconnected,
            // so we just continue to the next iteration
        }
    }
}