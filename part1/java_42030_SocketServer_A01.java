import java.io.*;
import java.net.*;

public class java_42030_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        // Step 1: Create a new ServerSocket
        ServerSocket serverSocket = new ServerSocket(PORT);

        // Step 2: Wait for a client to connect
        System.out.println("Waiting for a client to connect...");
        Socket clientSocket = serverSocket.accept();
        System.out.println("Client connected!");

        // Step 3: Get input and output streams
        InputStream input = clientSocket.getInputStream();
        OutputStream output = clientSocket.getOutputStream();

        // Step 4: Read from the client
        DataInputStream reader = new DataInputStream(input);
        String message = reader.readUTF();
        System.out.println("Client says: " + message);

        // Step 5: Send a response
        String response = "Hello, client!";
        output.writeUTF(response);

        // Step 6: Close the connection
        clientSocket.close();
        serverSocket.close();
    }
}