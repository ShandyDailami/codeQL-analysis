import java.io.*;
import java.net.*;

public class java_05267_SocketServer_A01 {
    private static final int PORT = 4000;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            while (true) {
                Socket client = server.accept();
                System.out.println("New client connected: " + client.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(client.getInputStream());
                DataOutputStream out = new DataOutputStream(client.getOutputStream());

                // read and validate the request
                String request = in.readUTF();
                if (request.equals("PING")) {
                    out.writeUTF("PONG");
                    out.flush();
                } else {
                    out.writeUTF("UNKNOWN COMMAND");
                    out.flush();
                }

                client.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}