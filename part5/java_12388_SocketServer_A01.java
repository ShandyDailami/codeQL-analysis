import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_12388_SocketServer_A01 {

    public static void main(String[] args) {
        try {
            // Create server socket
            ServerSocket serverSocket = new ServerSocket(8000);

            System.out.println("Server is listening on port 8000...");

            // Wait for a client to connect
            Socket clientSocket = serverSocket.accept();

            System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());

            // Get the input and output streams
            DataInputStream input = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream());

            // Send a message to the client
            output.writeUTF("Server is ready to receive messages from client");

            // Receive the message from the client
            String message = input.readUTF();
            System.out.println("Received message from client: " + message);

            // Close the connection
            clientSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}