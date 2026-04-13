import java.io.*;
import java.net.*;

public class java_17671_SocketServer_A03 {
    private static final int port = 1234;

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(port);
        System.out.println("Server is listening on port: " + port);

        while (true) {
            Socket client = server.accept();
            System.out.println("New client connected: " + client.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(client.getInputStream());
            DataOutputStream out = new DataOutputStream(client.getOutputStream());

            String message = in.readUTF();
            System.out.println("Client says: " + message);

            message = "Hello, Client!";
            out.writeUTF(message);
            out.flush();

            client.close();
        }
    }
}