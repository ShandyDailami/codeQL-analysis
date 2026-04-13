import java.io.*;
import java.net.*;

public class java_04175_SocketServer_A01 {
    private static final int PORT = 8888;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started on port " + PORT + ".");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // read username
            String username = in.readUTF();
            System.out.println("Received username: " + username);

            // write back to client
            out.writeUTF("Hello, " + username + "!");
            out.flush();

            socket.close();
        }
    }
}