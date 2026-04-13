import java.net.Socket;
import java.net.ServerSocket;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

public class java_35595_SocketServer_A01 {

    public static void main(String[] args) throws IOException {
        // Create a new ServerSocket that listens on port 8080
        ServerSocket server = new ServerSocket(8080);

        // Infinite loop to keep the server running
        while (true) {
            // Accept a new client connection
            Socket socket = server.accept();

            // Get InputStream and OutputStream from the socket
            InputStream input = socket.getInputStream();
            OutputStream output = socket.getOutputStream();

            // Send a welcome message to the client
            output.write("Welcome to the secure socket server!\n".getBytes());

            // Read the client's message and echo it back
            byte[] bytes = new byte[100];
            int length = input.read(bytes);
            output.write(bytes, 0, length);

            // Close the socket
            socket.close();
        }
    }
}