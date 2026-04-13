import java.io.*;
import java.net.*;

public class java_38015_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8189);
        while (true) {
            Socket client = server.accept();
            System.out.println("Accepted a connection from " + client.getRemoteSocketAddress());
            OutputStream out = new OutputStream(client.getOutputStream());
            DataOutputStream dos = new DataOutputStream(out);
            dos.writeUTF("Server says hello to the client!");
            dos.flush();
            client.close();
        }
    }
}