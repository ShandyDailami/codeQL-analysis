import java.io.*;
import java.net.*;
import java.util.*;

public class java_00599_SocketServer_A07 {
    private static final int port = 6666;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(port);

        while (true) {
            Socket socket = server.accept();

            System.out.println("Client connected from: " + socket.getRemoteSocketAddress());

            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF("Connected Successfully");

            DataInputStream in = new DataInputStream(socket.getInputStream());

            String clientMsg = in.readUTF();
            System.out.println("Client says: " + clientMsg);

            socket.close();
        }
    }
}