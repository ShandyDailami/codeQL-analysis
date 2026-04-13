import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_26879_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            // Step 1: Create a server socket at port 12345
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Server started at port 12345");

            while (true) {
                // Step 2: Accept a client connection
                Socket socket = serverSocket.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Step 3: Send a message back to the client
                socket.getOutputStream().write("Hello, Client!".getBytes());

                // Step 4: Handle client disconnection
                socket.close();

                // Step 5: Implementing encryption for security sensitive operations
                // Here we're just sending the same message back to the client
                socket.getOutputStream().write("Hello, Client!".getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}