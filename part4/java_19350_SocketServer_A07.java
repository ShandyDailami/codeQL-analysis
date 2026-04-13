import java.net.*;
import java.io.*;
import java.util.*;

public class java_19350_SocketServer_A07 {
    private static final String AUTH_SECRET = "A07_AuthSecret";

    public static void main(String[] args) throws IOException {
        int port = 1234;
        ServerSocket server = new ServerSocket(port);

        System.out.println("Server started at port " + port);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String clientMessage = dis.readUTF();
            System.out.println("Received: " + clientMessage);

            if (isAuthenticated(clientMessage)) {
                dos.writeUTF("Authentication successful");
            } else {
                dos.writeUTF("Authentication failed");
            }

            dos.close();
            socket.close();
        }
    }

    private static boolean isAuthenticated(String message) {
        return message.equals(AUTH_SECRET);
    }
}