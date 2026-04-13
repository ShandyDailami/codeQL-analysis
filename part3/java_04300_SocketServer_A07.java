import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_04300_SocketServer_A07 {
    public static void main(String[] args) {
        // Create a server socket
        try (Socket serverSocket = new Socket("localhost", 1234)) {
            // Create input and output streams
            try (BufferedReader in = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
                 PrintWriter out = new PrintWriter(serverSocket.getOutputStream(), true)) {

                // Read from the socket
                String request = in.readLine();
                System.out.println("Received: " + request);

                // Process the request
                String response = processRequest(request);

                // Send the response
                out.println(response);

            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String processRequest(String request) {
        // This is a placeholder for security-sensitive operations.
        // The request is simply echoed back.
        return request;
    }
}