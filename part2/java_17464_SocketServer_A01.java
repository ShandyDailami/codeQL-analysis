import java.io.*;
import java.net.*;

public class java_17464_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server started on port: " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String request = in.readUTF();
                System.out.println("Received: " + request);

                // Example of secure operations, such as Broken Access Control
                if (request.contains("admin")) {
                    out.writeUTF("Access denied");
                    out.close();
                    socket.close();
                } else {
                    out.writeUTF("Access granted");
                    out.close();
                    socket.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}