import java.io.*;
import java.net.*;

public class java_41819_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8189);

        System.out.println("Server is listening on port 8189...");

        while (true) {
            Socket socket = serverSocket.accept();

            System.out.println("New client connected: " + socket.getRemoteSocketAddress());

            // Create new input and output streams
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Read from client
            String message = in.readUTF();
            System.out.println("Received: " + message);

            // Send back to client
            out.writeUTF("Hello, client, your message was: " + message);
            out.flush();

            socket.close();
        }
    }
}