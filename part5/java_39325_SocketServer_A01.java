import java.io.*;
import java.net.*;

public class java_39325_SocketServer_A01 {
    private static final int PORT = 1234;
    private static final String SERVER_IP = "127.0.0.1";

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);

        System.out.println("Server started on port " + PORT + ".");

        while (true) {
            Socket socket = serverSocket.accept();

            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF();
            System.out.println("Received message: " + message);

            out.writeUTF("Message received!");
            out.flush();

            socket.close();
        }
    }
}