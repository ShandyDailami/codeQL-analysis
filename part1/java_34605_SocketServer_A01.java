import java.io.*;
import java.net.*;
import java.util.*;

public class java_34605_SocketServer_A01 {
    private static final String USAGE = "Usage: java BrokenSocketServer [port]";

    public static void main(String[] args) throws IOException {
        int port = 12345;
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        }
        ServerSocket server = new ServerSocket(port);
        System.out.println("Server started on port " + port);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF("Hello " + socket.getRemoteSocketAddress() + "\n");
            socket.close();
        }
    }
}