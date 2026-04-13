import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_39906_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Server is listening on port 5000");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // Create input and output streams
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            // Handle client's request
            String request = input.readUTF();
            System.out.println("Received request: " + request);

            output.writeUTF("Hello, client!");
            System.out.println("Sent response");

            // Close the connection
            output.close();
            input.close();
            socket.close();
        }
    }
}