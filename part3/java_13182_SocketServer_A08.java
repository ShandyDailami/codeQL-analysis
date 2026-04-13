import java.net.*;
import java.io.*;

public class java_13182_SocketServer_A08 {

    private static int port = 8888;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(port);
        System.out.println("Server started at port " + port);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Send message to client
            out.writeUTF("Hello Client, I am a Server!");

            // Close the connection
            socket.close();
        }
    }
}