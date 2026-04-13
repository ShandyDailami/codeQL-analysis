import java.io.*;
import java.net.*;
import java.util.*;

public class java_01377_SocketServer_A07 {
    private static final String USER = "user";
    private static final String PASS = "pass";

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(4444);
        System.out.println("Server started at " + server.getLocalSocketAddress());

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected at: " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String clientMsg = in.readUTF();
            System.out.println("Received: " + clientMsg);

            String serverMsg;
            if ("user".equals(clientMsg) && "pass".equals(PASS)) {
                serverMsg = "Welcome!";
            } else {
                serverMsg = "Access denied!";
            }

            out.writeUTF(serverMsg);
            out.close();
        }
    }
}