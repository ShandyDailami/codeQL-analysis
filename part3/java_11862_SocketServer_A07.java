import java.net.Socket;
import java.net.ServerSocket;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

public class java_11862_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        // Create a server socket
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is running...");

        while (true) {
            // Accept a client socket
            Socket clientSocket = serverSocket.accept();
            System.out.println("A client has connected...");

            // Create input and output streams
            InputStream input = clientSocket.getInputStream();
            OutputStream output = clientSocket.getOutputStream();

            // Read a message from the client
            byte[] bytes = new byte[1024];
            int length = input.read(bytes);
            String message = new String(bytes, 0, length);
            System.out.println("Received message: " + message);

            // Send a response back to the client
            String response = "Hello, " + message + "!\r\n";
            output.write(response.getBytes());

            // Close the connection
            clientSocket.close();
        }
    }
}