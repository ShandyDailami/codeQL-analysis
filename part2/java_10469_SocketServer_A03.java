import java.io.*;
import java.net.*;
import java.util.*;

public class java_10469_SocketServer_A03 {
    private static final String[] USERS = {"user1", "user2", "user3"};

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(12345);
        System.out.println("Server started on port 12345");

        while (true) {
            Socket socket = server.accept();
            System.out.println("New connection from " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            try {
                String username = in.readUTF();
                if (!Arrays.asList(USERS).contains(username)) {
                    out.writeUTF("Access denied");
                    out.flush();
                } else {
                    out.writeUTF("Access granted");
                    out.flush();
                }
            } catch (EOFException e) {
                System.out.println("Connection closed by " + socket.getRemoteSocketAddress());
            }

            socket.close();
        }
    }
}