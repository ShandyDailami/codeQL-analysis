import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_24421_SocketServer_A08 {

    public static void main(String[] args) throws Exception {
        // Create a new socket
        Socket socket = new Socket("localhost", 8080);

        // Get input and output stream from the socket
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        // Start the server
        out.println("Hello, Client!");

        // Read the message from the client
        String response = in.readLine();
        System.out.println("Server says: " + response);

        // Close the socket
        socket.close();
    }
}