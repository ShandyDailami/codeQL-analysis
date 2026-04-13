import java.io.*;
import java.net.*;

public class java_12727_SocketServer_A07 {

    public static void main(String[] args) throws IOException {
        // Create a server socket
        ServerSocket serverSocket = new ServerSocket(8080);

        System.out.println("Server is running and waiting for a client to connect...");

        // Accept a client socket
        Socket clientSocket = serverSocket.accept();

        System.out.println("Client connected!");

        // Create input and output streams
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        String inputLine;

        while ((inputLine = in.readLine()) != null) {
            System.out.println("Received: " + inputLine);

            // Here we're using a very simple form of client-server authentication
            // In a real-world scenario, this would involve sending a username and password,
            // and then checking them against a list of expected ones.
            if ("test".equals(inputLine)) {
                out.println("Authentication successful!");
            } else {
                out.println("Authentication failed!");
           
            }
        }

        // Close the resources
        clientSocket.close();
        serverSocket.close();
    }
}