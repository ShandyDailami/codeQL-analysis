import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_14423_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        // Step 1: Create a ServerSocket on the specified port
        ServerSocket server = new ServerSocket(PORT);

        System.out.println("Server is listening on port " + PORT);

        // Step 2: Accept a connection
        Socket socket = server.accept();

        // Step 3: Handle the connection
        // This is a placeholder, you'll need to implement your own logic
        // For example, you could read a message from the client, process it, and then send a response
        // Here, we'll just echo back the message
        byte[] bytes = new byte[1024];
        socket.getInputStream().read(bytes);
        String message = new String(bytes);

        System.out.println("Received message: " + message);

        // Step 4: Close the connection
        socket.getOutputStream().write((message + "\n").getBytes());
        socket.close();
    }
}