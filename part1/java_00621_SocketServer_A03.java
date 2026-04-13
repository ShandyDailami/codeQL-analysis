import java.io.*;
import java.net.*;

public class java_00621_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8189);
        System.out.println("Server started at " + server.getLocalSocketAddress());

        while (true) {
            Socket socket = server.accept();
            System.out.println("Accepted connection from " + socket.getRemoteSocketAddress());

            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF("Connection Successful!");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            String msg = in.readUTF();
            System.out.println("Received: " + msg);

            socket.close();
        }
    }
}