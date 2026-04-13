import java.io.*;
import java.net.*;

public class java_07270_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8189);
        System.out.println("Server started at " + server.getLocalSocketAddress());

        while(true) {
            Socket socket = server.accept();
            System.out.println("Connected to " + socket.getRemoteSocketAddress());

            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF("Server accepted connection from " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            System.out.println("Client says: " + in.readUTF());

            socket.close();
        }
    }
}