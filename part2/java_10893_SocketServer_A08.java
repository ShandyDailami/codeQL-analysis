import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_10893_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        // Step 1: Create a server socket
        ServerSocket serverSocket = new ServerSocket(8080);

        // Step 2: Wait for a client to connect
        Socket clientSocket = serverSocket.accept();

        // Step 3: Get the input and output streams from the client
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        // Step 4: Communicate with the client
        String message;
        while ((message = in.readLine()) != null) {
            System.out.println("Received: " + message);

            // Send the response back to the client
            out.println("Hello, you sent: " + message);
        }

        // Close the connections
        clientSocket.close();
        serverSocket.close();
    }
}