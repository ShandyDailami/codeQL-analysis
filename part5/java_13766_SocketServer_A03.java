import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_13766_SocketServer_A03 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        Socket socket = null;

        // Create a ServerSocket
        serverSocket = new ServerSocket(4444);
        System.out.println("Waiting for client on port " + 4444);

        // Accept a connection
        socket = serverSocket.accept();
        System.out.println("Client connected");

        // Get input and print out response
        byte[] buffer = new byte[1024];
        socket.getInputStream().read(buffer);
        String response = new String(buffer);
        System.out.println("Client says: " + response);

        // Send a response
        String message = "Hello Client";
        socket.getOutputStream().write(message.getBytes());

        // Close the connections
        socket.close();
        serverSocket.close();
    }
}