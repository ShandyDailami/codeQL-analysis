import java.io.*;
import java.net.*;

public class java_27888_SocketServer_A08 {
    private static final String SERVER_SOFTWARE = "SecureSocketServer/1.0";
    private static final int PORT = 5000;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server started. Waiting for client on port " + PORT);

            socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF();
            System.out.println("Client says: " + message);

            out.writeUTF("Server says: Hello, Client!");
            out.flush();

            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}