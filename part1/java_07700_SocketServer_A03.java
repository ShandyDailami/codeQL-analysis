import java.io.*;
import java.net.*;

public class java_07700_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(4444);
        System.out.println("Server started at port 4444");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected from: " + socket.getRemoteSocketAddress());

            // Insecure socket connection
            OutputStream out = socket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(out);
            dos.writeUTF("Insecure Connection established, do not attempt to execute code");

            // Close the socket
            socket.close();
        }
    }
}