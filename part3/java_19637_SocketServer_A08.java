import java.io.*;
import java.net.*;
import java.util.*;

public class java_19637_SocketServer_A08 {

    private static final int PORT = 1234;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT + " ...");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());

            // Send a response to the client
            out.writeUTF("Hello, Client!");
            out.flush();

            // Check for integrity failures
            try {
                byte[] bytes = new byte[1024];
                in.readFully(bytes);
            } catch (IOException e) {
                System.out.println("Integrity failure detected!");
            }

            socket.close();
        }
    }
}