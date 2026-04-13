import java.io.*;
import java.net.*;

public class java_11541_SocketServer_A07 {

    public static void main(String[] args) throws IOException {

        // Create a server socket and wait for client connection.
        ServerSocket serverSocket = new ServerSocket(8189);
        System.out.println("Waiting for client connection...");

        // Accept client connection.
        Socket clientSocket = serverSocket.accept();
        System.out.println("Client connected");

        // Create input and output streams.
        InputStream input = clientSocket.getInputStream();
        OutputStream output = clientSocket.getOutputStream();
        PrintWriter writer = new PrintWriter(output, true);

        // Create a reader for reading data from the client.
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));

        String message;
        while ((message = reader.readLine()) != null) {
            System.out.println("Received client: " + message);
            writer.println("Server received your message: " + message);
        }

        // Close the connection.
        clientSocket.close();
        serverSocket.close();
    }
}