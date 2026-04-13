import java.io.*;
import java.net.*;

public class java_26319_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        while (true) {
            Socket socket = server.accept();
            System.out.println("New connection accepted: " + socket.getRemoteSocketAddress());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF("Server is running!");
        }
    }
}