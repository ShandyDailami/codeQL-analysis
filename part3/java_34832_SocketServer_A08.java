import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_34832_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        // Create a server socket
        Socket serverSocket = new Socket("localhost", 8080);

        // Create input and output streams
        BufferedReader in = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
        PrintWriter out = new PrintWriter(serverSocket.getOutputStream(), true);

        // Send a message to the server
        out.println("Hello, Server!");

        // Read the server's response
        String response = in.readLine();
        System.out.println("Server says: " + response);

        // Close the connection
        serverSocket.close();
    }
}