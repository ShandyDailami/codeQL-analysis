import java.io.*;
import java.net.*;

public class java_13410_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        // Create a server socket
        ServerSocket serverSocket = new ServerSocket(8080);

        System.out.println("Server started!");

        // Listen for incoming client connections
        while (true) {
            Socket clientSocket = serverSocket.accept();

            // Create input and output streams
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String inputLine;
            // Read from the client
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Received: " + inputLine);
                // Send a response back to the client
                out.println("Hello, client!");
            }

            // Close the streams
            out.close();
            in.close();
            clientSocket.close();
       
        }
    }
}