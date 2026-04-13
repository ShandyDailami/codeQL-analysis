import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_22662_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            // Setup server socket
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Server is listening on port 1234");

            while (true) {
                // Accept a client connection
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // Send a message to the client
                socket.getOutputStream().write("Hello, Client!\n".getBytes());

                // Close the connection
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}