import java.io.*;
import java.net.*;

public class java_42155_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(12345);
        System.out.println("Waiting for client...");

        Socket client = server.accept();
        System.out.println("Client connected!");

        DataInputStream in = new DataInputStream(client.getInputStream());
        DataOutputStream out = new DataOutputStream(client.getOutputStream());

        String message = in.readUTF();
        System.out.println("Received: " + message);

        out.writeUTF("Hello Client, You are connected!");
        out.flush();

        client.close();
        server.close();
    }
}