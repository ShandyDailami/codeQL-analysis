import java.io.*;
import java.net.*;
import java.util.*;

public class java_08565_SocketServer_A01 {
    private static final String USER = "user";
    private static final String PASSWORD = "password";

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);

        System.out.println("Server started. Waiting for client connection...");

        Socket socket = server.accept();

        System.out.println("Client accepted from: " + socket.getRemoteSocketAddress());

        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        String clientMsg = in.readUTF();

        System.out.println("Client says: " + clientMsg);

        String serverMsg;

        if ("Auth hello".equals(clientMsg)) {
            serverMsg = "HTTP/1.1 200 OK\n" +
                    "Content-Type: text/html; charset=utf-8\n" +
                    "Set-Cookie: session=valid; path=/\n" +
                    "\n" +
                    "<h1>Welcome back!</h1>";
        } else {
            serverMsg = "HTTP/1.1 401 Unauthorized\n" +
                    "Content-Type: text/html; charset=utf-8\n" +
                    "\n" +
                    "<h1>Access denied.</h1>";
        }

        out.writeUTF(serverMsg);

        out.close();
        in.close();
        socket.close();
        server.close();
    }
}