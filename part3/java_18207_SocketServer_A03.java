import java.io.*;
import java.net.*;

public class java_18207_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(6000);
        while (true) {
            Socket sock = server.accept();
            DataInputStream in = new DataInputStream(sock.getInputStream());
            DataOutputStream out = new DataOutputStream(sock.getOutputStream());

            String str = in.readUTF(); // this could be a potential injection point
            System.out.println(str);

            out.writeUTF("Server received");
            out.flush();
            sock.close();
        }
    }
}