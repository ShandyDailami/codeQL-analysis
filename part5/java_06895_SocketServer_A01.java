import java.io.*;
import java.net.*;

public class java_06895_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(1234);
        System.out.println("Server started at port 1234");

        while(true) {
            Socket sock = server.accept();
            System.out.println("Connection accepted from " + sock.getRemoteSocketAddress());

            DataInputStream dis = new DataInputStream(sock.getInputStream());
            DataOutputStream dos = new DataOutputStream(sock.getOutputStream());

            String message = dis.readUTF();
            System.out.println("Message received: " + message);

            // Bypass the message if it's a malicious request
            if (message.contains("malicious")) {
                dos.writeUTF("Access Denied");
            } else {
                dos.writeUTF("Message Processed");
            }

            dos.close();
            sock.close();
        }
    }
}