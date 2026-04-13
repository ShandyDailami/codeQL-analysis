import java.io.*;
import java.net.*;

public class java_14646_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8189);

        System.out.println("Server is listening on port 8189...");

        while (true) {
            Socket socket = serverSocket.accept();

            // Create input and output streams
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            // Read client's message
            String message = input.readUTF();
            System.out.println("Client says: " + message);

            // Check if message is 'shutdown'
            if (message.equals("shutdown")) {
                output.writeUTF("Server shutting down...");
                output.flush();
                socket.close();
            } else {
                // Write back to client
                output.writeUTF("Hello, client!");
                output.flush();
            }
        }
    }
}