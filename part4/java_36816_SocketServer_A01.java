import java.io.*;
import java.net.*;
import java.util.*;

public class java_36816_SocketServer_A01 {
    private static final String LOCAL_HOST = "localhost";
    private static final int PORT = 8080;
    private static final List<String> ALLOWED_IPS = Arrays.asList("192.168.1.1", "127.0.0.1");

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server is running on port: " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("A client has connected from " + socket.getRemoteSocketAddress());

            String clientIP = socket.getRemoteSocketAddress().toString().substring(socket.getRemoteSocketAddress().toString().lastIndexOf(":") + 1);

            if (!ALLOWED_IPS.contains(clientIP)) {
                System.out.println("Connection from " + clientIP + " is not allowed, closing connection");
                socket.close();
                continue;
            }

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            out.writeUTF("Connection successful from " + clientIP);

            String message = in.readUTF();
            System.out.println("Message from client: " + message);

            socket.close();
        }
    }
}