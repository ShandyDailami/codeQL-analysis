import java.io.*;
import java.net.*;

public class java_26372_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(6000);
        System.out.println("Server started at " + server.getLocalSocketAddress());

        while (true) {
            Socket client = server.accept();
            System.out.println("Client connected at " + client.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(client.getInputStream());
            DataOutputStream out = new DataOutputStream(client.getOutputStream());

            String message = in.readUTF();
            System.out.println("Received: " + message);

            out.writeUTF("Message received");
            out.flush();

            client.close();
        }
    }
}