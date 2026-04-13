import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_17770_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        // Step 1: Create a server socket and listen on port 1234
        ServerSocket serverSocket = new ServerSocket(1234);

        while (true) {
            // Step 2: Accept a client connection
            Socket clientSocket = serverSocket.accept();

            // Step 3: Get input and output streams from the socket
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Step 4: Send a message to the client
            out.println("Hello, client!");

            // Step 5: Close the connection
            clientSocket.close();
        }
    }
}