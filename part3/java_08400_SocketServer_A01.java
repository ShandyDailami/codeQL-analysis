import java.io.*;
import java.net.*;

public class java_08400_SocketServer_A01 {
    private static final String SERVER_SOCKET_ADDRESS = "localhost";
    private static final int SERVER_SOCKET_PORT = 1234;
    private static final int BUFFER_SIZE = 1024;

    public static void main(String[] args) {
        try {
            // Step 1: Create a server socket
            ServerSocket serverSocket = new ServerSocket(SERVER_SOCKET_PORT);
            System.out.println("Server listening on port " + SERVER_SOCKET_PORT);

            // Step 2: Accept a client connection
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());

            // Step 3: Handle the client connection
            InputStream inputStream = clientSocket.getInputStream();
            OutputStream outputStream = clientSocket.getOutputStream();

            // Step 4: Read data from the client
            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead = inputStream.read(buffer);
            System.out.println("Received " + bytesRead + " bytes from client");

            // Step 5: Write data to the client
            String response = "Hello, client!";
            outputStream.write(response.getBytes());
            System.out.println("Sent " + response.length() + " bytes to client");

            // Close the connection
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}