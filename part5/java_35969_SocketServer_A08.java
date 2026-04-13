import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_35969_SocketServer_A08 {

    public static void main(String[] args) {
        // Create server socket
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            System.out.println("Server is listening on port 8080");

            while (true) {
                // Wait for client to connect
                try (Socket clientSocket = serverSocket.accept()) {
                    System.out.println("New client connected");

                    // Create input and output streams
                    try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                         PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                        // Read message from client
                        String message = in.readLine();
                        System.out.println("Received message: " + message);

                        // Send response to client
                        out.println("Hello, client!");
                        System.out.println("Sent message: " + out.toString());
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Exception caught!");
            e.printStackTrace();
        }
    }
}