import java.io.*;
import java.net.*;

public class java_41494_SocketServer_A07 {
    private static final int PORT = 9999;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected " + socket.getRemoteSocketAddress());

            // Write your code here to handle the socket operations
            // ...
        }
    }
}