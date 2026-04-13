import java.io.*;
import java.net.*;

public class java_22426_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(6000);
            System.out.println("Waiting for client...");

            Socket sock = server.accept();
            System.out.println("Connected to: " + sock.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(sock.getInputStream());
            DataOutputStream out = new DataOutputStream(sock.getOutputStream());

            String message = in.readUTF();
            System.out.println("Received: " + message);

            out.writeUTF("Hello client, you connected to server!");
            System.out.println("Sent: " + "Hello client, you connected to server!");

            sock.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}