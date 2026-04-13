import java.io.*;
import java.net.*;
import java.util.*;

public class java_41351_SocketServer_A01 {
    private static final String[] ALLOWED_IPS = {"127.0.0.1", "192.168.1.100"}; // add more allowed ips here

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(12345);
        System.out.println("Server started...");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected from: " + socket.getRemoteSocketAddress());

            String clientIP = socket.getRemoteSocketAddress().toString();
            if (!Arrays.asList(ALLOWED_IPS).contains(clientIP)) {
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                out.println("Access Denied");
                out.close();
                socket.close();
                System.out.println("Client IP (" + clientIP + ") is not allowed to connect!");
                continue;
            }

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String line;
            while ((line = in.readLine()) != null) {
                out.println("Server: " + line);
            }

            out.close();
            in.close();
            socket.close();
        }
    }
}