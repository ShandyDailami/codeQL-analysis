import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;

public class java_15326_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        // Create a SSL Server Socket
        SSLServerSocket serverSocket = (SSLServerSocket) new SSLServerSocket(8080);

        while (true) {
            // Wait for a client connection
            SSLSocket clientSocket = (SSLSocket) serverSocket.accept();

            // Get the input and output streams from the client
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Handle client communication
            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);
                // Send a response back to the client
                out.println("Server Response: " + message);
            }

            // Close the connection
            clientSocket.close();
        }
    }
}