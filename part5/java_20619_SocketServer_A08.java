import java.io.*;
import java.net.*;

public class java_20619_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(4444);
        System.out.println("Waiting for client connection...");

        Socket socket = server.accept();
        System.out.println("Connected to: " + socket.getRemoteSocketAddress());

        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        String data;
        while ((data = in.readUTF()) != null) {
            System.out.println("Received: " + data);
            out.writeUTF(data);
            System.out.println("Sent: " + data);
        }
        socket.close();
    }
}