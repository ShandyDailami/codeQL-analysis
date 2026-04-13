import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_35891_SocketServer_A08 {

    public static void main(String[] args) throws IOException {
        // Create a server socket
        Socket socket = new Socket("localhost", 9876);

        // Get the output stream from the socket
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        // Create a reader to read input from the socket
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        // Send a message to the client
        out.println("Hello, client!");

        // Read a line of text from the client
        String message = in.readLine();
        System.out.println("Server received: " + message);

        // Close the connection
        socket.close();
    }

}