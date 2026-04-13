import java.io.*;
import java.net.*;

public class java_26783_SocketServer_A01 {
    private static final int PORT = 4446;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("A new client is connected: " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message;
            while ((message = in.readUTF()) != null) {
                System.out.println("Received: " + message);
                out.writeUTF("Echo: " + message);
            }

            socket.close();
        }
    }
}