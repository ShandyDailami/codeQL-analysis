import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_25109_SocketServer_A08 {

    public static void main(String[] args) throws IOException {
        // Create server socket
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080");

        while (true) {
            // Accept client connection
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            // Send message to client
            DataOutputStream outputStream = new DataOutputStream(clientSocket.getOutputStream());
            outputStream.writeUTF("Hello Client, I am a Socket Server!");

            // Close connections
            clientSocket.close();
        }
    }
}