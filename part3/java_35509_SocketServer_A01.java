import java.io.*;
import java.net.*;

public class java_35509_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Waiting for client connection...");

        Socket client = server.accept();
        System.out.println("Client connected!");

        DataInputStream in = new DataInputStream(client.getInputStream());
        DataOutputStream out = new DataOutputStream(client.getOutputStream());

        String message = in.readUTF();
        System.out.println("Received message: " + message);

        out.writeUTF("Hello, client!");
        System.out.println("Message sent");

        client.close();
        server.close();
    }
}