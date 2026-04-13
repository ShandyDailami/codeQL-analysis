import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_21773_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        // Create a ServerSocket that listens for client connections
        ServerSocket serverSocket = new ServerSocket(4444);

        while (true) {
            // Wait for a client to connect
            Socket clientSocket = serverSocket.accept();

            // Create a BufferedReader to read client messages
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            // Create a PrintWriter to send messages to the client
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Read a client message and send a response
            String message = in.readLine();
            out.println("Server received: " + message);

            // Close the connection
            clientSocket.close();
        }
    }
}