import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_17364_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        // Step 1: Create a server socket and listen for connections
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Waiting for connection...");

        // Step 2: Accept a client connection
        Socket socket = serverSocket.accept();
        System.out.println("Connected to " + socket.getRemoteSocketAddress());

        // Step 3: Handle the connection
        // For this example, we'll just write a response back to the client
        String response = "Hello, client!";
        socket.getOutputStream().write(response.getBytes());

        // Step 4: Close the connection
        socket.close();
        serverSocket.close();
    }
}