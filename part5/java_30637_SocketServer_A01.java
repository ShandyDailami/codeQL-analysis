import java.io.*;
import java.net.*;

public class java_30637_SocketServer_A01 {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(4444);
        while (true) {
            Socket socket = server.accept();
            System.out.println("Connected to " + socket.getRemoteSocketAddress());
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String request = in.readUTF();
            System.out.println("Received: " + request);

            if (request.equals("Ban User")) {
                out.writeUTF("Access Denied");
                out.close();
            } else {
                out.writeUTF("Access Allowed");
                out.close();
            }

            socket.close();
        }
    }
}