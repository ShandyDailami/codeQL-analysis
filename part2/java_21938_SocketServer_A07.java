import java.io.*;
import java.net.*;

public class java_21938_SocketServer_A07 {
    public static void main(String[] args) {
        int port = 1234;
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started on port: " + port);

            socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF();
            System.out.println("Received: " + message);

            out.writeUTF("Hello Client, you connected successfully!");
            out.flush();

            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}