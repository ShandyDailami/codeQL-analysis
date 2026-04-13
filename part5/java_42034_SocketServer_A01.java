import java.net.*;
import java.io.*;

public class java_42034_SocketServer_A01 {
    public static void main(String args[]) throws Exception {
        ServerSocket server = new ServerSocket(6000);
        System.out.println("Waiting for client on port 6000...");

        while (true) {
            Socket sock = server.accept();
            System.out.println("Connection from " + sock.getRemoteSocketAddress());

            OutputStream out = sock.getOutputStream();
            DataOutputStream dos = new DataOutputStream(out);

            dos.writeUTF("Connection established. Please type a message and press enter.");

            InputStream in = sock.getInputStream();
            DataInputStream dis = new DataInputStream(in);

            String message = dis.readUTF();
            System.out.println("Client said: " + message);

            dos.writeUTF("Message received. Thank you for your message.");
            sock.close();
        }
    }
}