import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_18476_SocketServer_A08 {

    public static void main(String[] args) throws IOException {
        // Set up a server socket
        int port = 5000;
        Socket socket = new Socket("localhost", port);

        // Get the input and output streams from the socket
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        // Send a message to the client
        out.println("Hello, client!");

        // Read the server's response
        String response = in.readLine();
        System.out.println("Server said: " + response);

        // Close the socket
        socket.close();
    }
}