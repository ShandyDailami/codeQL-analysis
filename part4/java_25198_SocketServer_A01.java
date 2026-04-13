import java.net.*;
import java.io.*;

public class java_25198_SocketServer_A01 {

    private static final String TRUSTED_IP = "127.0.0.1"; // Trusted IP address
    private static final int PORT = 4445; // Socket server port

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected from: " + socket.getRemoteSocketAddress());

            // Check if the client's IP address is trusted
            InetAddress clientAddress = socket.getRemoteSocketAddress();
            if (clientAddress.getHostAddress().equals(TRUSTED_IP)) {
                // If client's IP is trusted, write a message to the client
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                out.writeUTF("Hello, you are connected to the server!");
            } else {
                System.out.println("Client's IP address (" + socket.getRemoteSocketAddress() + ") is not trusted!");
           
                // Close the connection with the client
                socket.close();
            }
        }
    }
}