import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_14164_SocketServer_A08 {

    public static void main(String[] args) {
        try {
            // Create a server socket
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Server started");

            while (true) {
                // Wait for client to connect
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // Handle the client communication
                // Here, we're assuming that the client sends a string and the server responds with that string.
                // This is a very basic example, and real-world servers would need more complex handling.
                String clientMessage = socket.getInputStream().readUTF();
                socket.getOutputStream().writeUTF(clientMessage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}