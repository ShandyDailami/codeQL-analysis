import java.io.*;
import java.net.*;

public class java_24173_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);

        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();

            System.out.println("Connected to " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF();
            System.out.println("Received: " + message);

            out.writeUTF("Hello, client!");
            System.out.println("Sent: " + "Hello, client!");

            socket.close();
        }
    }
}