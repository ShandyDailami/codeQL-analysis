import java.io.*;
import java.net.*;

public class java_28412_SocketServer_A01 {

    public static void main(String[] args) throws IOException {

        // Create a server socket and listen on port 12345
        ServerSocket serverSocket = new ServerSocket(12345);

        while (true) {

            // Wait for a client to connect
            Socket clientSocket = serverSocket.accept();

            // Get a input stream from the socket and a output stream to the client
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Read the client's message
            String message = in.readLine();

            // Respond to the client with a message from them
            out.println("Hello, client!");
       
            // Close the connection
            clientSocket.close();
        }
    }
}