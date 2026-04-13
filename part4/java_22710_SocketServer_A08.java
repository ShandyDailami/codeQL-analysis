import java.net.*;
import java.io.*;

public class java_22710_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(6000);
        while (true) {
            Socket sock = server.accept();
            System.out.println("Accepted connection from " + sock.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(sock.getInputStream());
            DataOutputStream out = new DataOutputStream(sock.getOutputStream());

            String message = in.readUTF();
            System.out.println("Received: " + message);

            if (message.equals("quit")) {
                out.writeUTF("Bye!");
                sock.close();
            } else {
                out.writeUTF("Thank you for connecting to server");
            }
            out.flush();
        }
    }
}