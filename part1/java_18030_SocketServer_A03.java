import java.io.*;
import java.net.*;

public class java_18030_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8189);
        System.out.println("Server is listening on port 8189");

        while (true) {
            Socket client = server.accept();
            System.out.println("New client connected");

            DataInputStream dis = new DataInputStream(client.getInputStream());
            DataOutputStream dos = new DataOutputStream(client.getOutputStream());

            String message = dis.readUTF();
            System.out.println("Received: " + message);

            dos.writeUTF("Thank you for connecting to " + client.getRemoteSocketAddress());
            dos.flush();
            client.close();
        }
    }
}