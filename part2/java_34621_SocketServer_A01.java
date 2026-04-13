import java.net.*;
import java.io.*;

public class java_34621_SocketServer_A01 {

    public static void main(String[] args) throws Exception {

        ServerSocket server = new ServerSocket(4444);
        System.out.println("Server started at port 4444");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            // Disable access to the server for the client
            socket.setTcpNoDelay(true);
            socket.setKeepAlive(true);

            OutputStream out = socket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(out);
            dos.writeUTF("Access Denied");

            socket.close();
        }
    }
}