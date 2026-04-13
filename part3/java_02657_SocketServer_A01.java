import java.io.*;
import java.net.*;

public class java_02657_SocketServer_A01 {
    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server is running...");

        while (true) {
            Socket client = server.accept();
            System.out.println("Client connected from: " + client.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(client.getInputStream());
            DataOutputStream out = new DataOutputStream(client.getOutputStream());

            String message;
            while ((message = in.readUTF()) != null) {
                System.out.println("Received message: " + message);
                out.writeUTF(message);
                out.flush();
            }

            client.close();
        }
    }
}