import java.net.InetSocketAddress;
import java.net.Socket;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class java_37418_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        // Create the server socket
        Socket socket = new Socket();
        socket.bind(new InetSocketAddress("localhost", 12345));
        System.out.println("Server started on port 12345");

        // Wait for client connection
        socket.listen();
        Socket client = socket.accept();
        System.out.println("Connected to client");

        // Get input and output streams
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        PrintWriter out = new PrintWriter(client.getOutputStream(), true);

        // Send a greeting
        out.println("Hello, client!");

        // Read and print the client's message
        String message = in.readLine();
        System.out.println("Client said: " + message);

        // Close the connection
        client.close();
        socket.close();
    }
}