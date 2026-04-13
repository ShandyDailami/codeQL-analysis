import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_12947_SocketServer_A01 {

    public static void main(String[] args) throws IOException {
        // Create a server socket and wait for a client to connect
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Waiting for client to connect...");
        Socket socket = serverSocket.accept();
        System.out.println("Client connected!");

        // Get the input and output streams from the client
        InputStream input = socket.getInputStream();
        OutputStream output = socket.getOutputStream();

        // Create a byte array to hold the data received
        byte[] data = new byte[1024];
        int bytesRead = input.read(data);
        String message = new String(data, 0, bytesRead);
        System.out.println("Received message: " + message);

        // Send a response back to the client
        String response = "Hello, client!";
        output.write(response.getBytes());

        // Close the connection
        socket.close();
        serverSocket.close();
    }
}