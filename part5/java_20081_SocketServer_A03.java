import java.io.*;
import java.net.*;

public class java_20081_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8189);
        System.out.println("Server started at " + server.getLocalSocketAddress());

        while(true) {
            Socket socket = server.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String clientMsg = dis.readUTF();
            System.out.println("Client says: " + clientMsg);

            String serverMsg = "Hello client, you connected successfully!";
            dos.writeUTF(serverMsg);
            dos.flush();
        }
    }
}