import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_31892_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        // Create a socket for listening on port 9000
        java.net.ServerSocket serverSocket = new java.net.ServerSocket(9000);

        while (true) {
            // Accept a new client connection
            Socket clientSocket = serverSocket.accept();

            // Create input and output streams for communication with the client
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Read from the client
            String message = in.readLine();
            System.out.println("Received: " + message);

            // Send a response back to the client
            out.println("Hello, client!");

            // Close the connections
            clientSocket.close();
        }
    }
}