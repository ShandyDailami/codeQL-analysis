import java.io.*;
import java.net.*;

public class java_09998_SocketServer_A03 {
    public static void main(String[] args) {
        int port = 4445;
        ServerSocket server = null;
        Socket client = null;
        DataInputStream dis = null;
        DataOutputStream dos = null;
        try {
            server = new ServerSocket(port);
            System.out.println("Waiting for client on port " + port);
            client = server.accept();
            System.out.println("Connected with " + client.getRemoteSocketAddress());
            dis = new DataInputStream(client.getInputStream());
            dos = new DataOutputStream(client.getOutputStream());
            String message;
            while (true) {
                message = dis.readUTF();
                System.out.println("Client says: " + message);
                if (message.equals("exit")) {
                    break;
                }
                message = "Server says: " + message;
                dos.writeUTF(message);
            }
            client.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (dis != null) dis.close();
                if (dos != null) dos.close();
                if (client != null) client.close();
                if (server != null) server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}