import java.io.*;
import java.net.*;

public class java_14485_SocketServer_A01 {
    private static final int PORT = 8888;

    public static void main(String[] args) {
        ServerSocket server = null;
        try {
            server = new ServerSocket(PORT);
            System.out.println("Server started at port " + PORT);

            while (true) {
                Socket client = server.accept();
                System.out.println("Client connected from " + client.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(client.getInputStream());
                DataOutputStream out = new DataOutputStream(client.getOutputStream());

                String message = in.readUTF();
                System.out.println("Received: " + message);

                out.writeUTF("Server response: " + message);
                out.flush();
                System.out.println("Sent: " + "Server response: " + message);

                client.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}