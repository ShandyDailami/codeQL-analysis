import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_15365_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            // Step 1: Create a ServerSocket
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Server started. Waiting for connections on port 12345...");

            while (true) {
                // Step 2: Accept a client socket
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // Step 3: Perform I/O operations on the socket
                // Here, we just read data from the socket and print it
                byte[] bytes = new byte[1024];
                socket.getInputStream().read(bytes);
                String message = new String(bytes);
                System.out.println("Received message: " + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}