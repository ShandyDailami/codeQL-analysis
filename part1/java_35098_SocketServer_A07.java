import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_35098_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        // Step 1: Setup the server
        ServerSocket serverSocket = new ServerSocket(8080);

        System.out.println("Server is listening on port 8080...");

        while (true) {
            // Step 2: Accept a client connection
            Socket socket = serverSocket.accept();

            // Step 3: Handle the client
            // For the sake of simplicity, we'll just send a simple "Hello" message back
            // to the client. In a real application, you'd likely want to handle
            // multiple clients and perform more complex tasks.
            String message = "Hello, client!\n";

            socket.getOutputStream().write(message.getBytes());

            // Close the connection
            socket.close();
        }
    }
}