import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_37465_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        // Create a new socket on port 4444
        Socket socket = new Socket("localhost", 4444);

        // Get a reader for the socket
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        // Get a writer for the socket
        PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

        // Read a line of text from the client
        String line = input.readLine();

        // Send a line of text back to the client
        output.println("Hello, client, you said: '" + line + "'");

        // Close the socket
        socket.close();
    }
}