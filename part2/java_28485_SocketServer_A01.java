import java.io.*;
import java.net.*;

public class java_28485_SocketServer_A01 {
    private static final String HOST = "localhost";
    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        // Create a socket
        ServerSocket serverSocket = new ServerSocket(PORT);

        System.out.println("Server started!");

        // Listen for connections
        while (true) {
            Socket socket = serverSocket.accept();

            // Create an input stream and an output stream for communication
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Handshake to confirm the client is who it claims to be
            out.writeUTF("Client says hello, Server says hello");
            String clientMessage = in.readUTF();
            System.out.println("Client says: " + clientMessage);

            // Close the streams
            out.close();
            in.close();

            // Close the socket
            socket.close();
        }
    }
}