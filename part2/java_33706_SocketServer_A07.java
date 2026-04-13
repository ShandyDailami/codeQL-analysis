import java.io.*;
import java.net.*;
import java.util.*;

public class java_33706_SocketServer_A07 {
    private static final int PORT = 9999;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server is listening on port: " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF();
            System.out.println("Client says: " + message);

            if (message.equals("auth")) {
                // Authenticate the user and send a response back
                out.writeUTF("Successfully authenticated");
                out.flush();
            } else {
                // Otherwise, return an unauthenticated message
                out.writeUTF("Unauthenticated");
                out.flush();
            }

            socket.close();
        }
    }
}