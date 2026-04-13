import java.net.ServerSocket;
import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class java_24353_SocketServer_A01 {
    public static void main(String[] args) {
        int port = 9999; // Choose an arbitrary port

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port: " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                // Create input and output streams
                DataInputStream inputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

                // Send a message to the client
                String message = "Hello, client!";
                outputStream.writeUTF(message);
                System.out.println("Server: Sent message to client: " + message);

                // Read a message from the client
                String receivedMessage = inputStream.readUTF();
                System.out.println("Client: Received message: " + receivedMessage);

                // Close the connection
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}