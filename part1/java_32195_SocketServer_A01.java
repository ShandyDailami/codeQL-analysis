import java.io.*;
import java.net.*;

public class java_32195_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8189);
        System.out.println("Waiting for client...");

        Socket client = server.accept();
        System.out.println("Connected!");

        DataInputStream in = new DataInputStream(client.getInputStream());
        DataOutputStream out = new DataOutputStream(client.getOutputStream());

        String message;
        while ((message = in.readUTF()) != null) {
            System.out.println("Received: " + message);
            out.writeUTF("Echo: " + message);
        }

        client.close();
    }
}