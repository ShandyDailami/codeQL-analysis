import java.io.*;
import java.net.*;
import java.util.*;

public class java_38848_SocketServer_A03 {
    private static int port = 12345;
    private static String name;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started at port: " + port);

            while (true) {
                socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String request = in.readUTF();
                System.out.println("Received request: " + request);

                // Check for injection here. For example,
                // if request contains SQL or command injection, we should not allow it.

                // Check for SQL injection.
                if (request.contains("SELECT")) {
                    System.out.println("Suspicious activity detected: SQL injection attempt");
                    out.writeUTF("Suspicious activity detected: SQL injection attempt");
                } else {
                    out.writeUTF("Hello, Client");
                }

                out.flush();
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}