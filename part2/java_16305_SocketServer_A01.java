import java.io.*;
import java.net.*;

public class java_16305_SocketServer_A01 {
    private static final int port = 12345;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server is listening on port: " + port);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getRemoteSocketAddress());

            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());

            // Write a message to the client
            out.writeUTF("Hello, client!");
            System.out.println("Message sent to client!");

            // Read a message from the client
            String message = in.readUTF();
            System.out.println("Message received from client: " + message);

            socket.close();
        }
    }
}