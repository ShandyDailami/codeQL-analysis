import java.io.*;
import java.net.*;

public class java_27338_SocketServer_A01 {
    public static void main(String[] args) {
        int port = 1234;
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Server is running on port: " + port);

            while (true) {
                Socket client = server.accept();
                System.out.println("Client connected: " + client.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(client.getInputStream());
                DataOutputStream out = new DataOutputStream(client.getOutputStream());

                String message = in.readUTF();
                System.out.println("Received: " + message);

                out.writeUTF("Server received your message: " + message);
                out.flush();

                client.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}