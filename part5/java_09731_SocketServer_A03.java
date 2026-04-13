import java.net.*;
import java.io.*;

public class java_09731_SocketServer_A03 {
    public static void main(String args[]) {
        try {
            ServerSocket server = new ServerSocket(6000);
            while (true) {
                Socket sock = server.accept();
                System.out.println("Connected to: " + sock.getRemoteSocketAddress());
                DataInputStream in = new DataInputStream(sock.getInputStream());
                DataOutputStream out = new DataOutputStream(sock.getOutputStream());
                String str = in.readUTF();
                System.out.println("Received: " + str);
                out.writeUTF("Server: " + str);
                sock.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}