import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_09346_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        // Create a server socket
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080...");

        while (true) {
            // Accept a new client
            Socket clientSocket = serverSocket.accept();
            System.out.println("New client connected");

            // Get input and output streams
            InputStream input = clientSocket.getInputStream();
            OutputStream output = clientSocket.getOutputStream();

            // Read from the client
            byte[] bytes = new byte[1024];
            int length = input.read(bytes);
            String message = new String(bytes, 0, length);
            System.out.println("Received: " + message);

            // Send a response
            String response = "Hello client, your message was: " + message;
            output.write(response.getBytes());

            // Close the connection
            clientSocket.close();
        }
    }
}