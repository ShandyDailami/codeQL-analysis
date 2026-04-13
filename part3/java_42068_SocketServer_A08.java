import java.io.*;
import java.net.*;

public class java_42068_SocketServer_A08 {
    private static int port = 12345;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Server is listening on port: " + port);

            while (true) {
                Socket client = server.accept();
                System.out.println("Client connected: " + client.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(client.getInputStream());
                DataOutputStream out = new DataOutputStream(client.getOutputStream());

                String message = in.readUTF();
                System.out.println("Received message from client: " + message);

                out.writeUTF("Message received");
                out.flush();

                client.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}