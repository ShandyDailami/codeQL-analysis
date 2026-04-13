import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_30812_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(1234);
        System.out.println("Server is listening on port 1234...");

        while (true) {
            Socket client = server.accept();
            System.out.println("Client connected: " + client.getRemoteSocketAddress());

            DataInputStream input = new DataInputStream(client.getInputStream());
            DataOutputStream output = new DataOutputStream(client.getOutputStream());

            String message = input.readUTF(); // Read a message from the client
            System.out.println("Received: " + message);

            String response = "Server received your message: " + message;
            output.writeUTF(response); // Send a response back to the client
            output.flush();
        }
    }
}