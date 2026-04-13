import java.io.*;
import java.net.*;

public class java_00004_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Waiting for connection on port 8080...");

        Socket client = server.accept();
        System.out.println("Connected with " + client.getRemoteSocketAddress());

        DataInputStream in = new DataInputStream(client.getInputStream());
        DataOutputStream out = new DataOutputStream(client.getOutputStream());

        String message = in.readUTF();
        System.out.println("Received: " + message);

        String response = "Hello, client!";
        out.writeUTF(response);
        System.out.println("Sent: " + response);

        client.close();
    }
}