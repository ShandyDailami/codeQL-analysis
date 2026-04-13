import java.io.*;
import java.net.*;

public class java_16506_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(12345);
        System.out.println("Server is listening on port 12345...");

        while (true) {
            Socket client = server.accept();
            System.out.println("Accepted new connection from " + client.getRemoteSocketAddress());

            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            out.writeUTF("Welcome to the server!");

            DataInputStream in = new DataInputStream(client.getInputStream());
            System.out.println("Client says: " + in.readUTF());

            client.close();
        }
    }
}