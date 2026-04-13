import java.io.*;
import java.net.*;

public class java_36386_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(12345);
        System.out.println("Server is listening at port 12345");

        while (true) {
            Socket client = server.accept();
            System.out.println("Client connected");

            DataInputStream in = new DataInputStream(client.getInputStream());
            DataOutputStream out = new DataOutputStream(client.getOutputStream());

            String message = in.readUTF();
            System.out.println("Received: " + message);

            out.writeUTF("Server received your message");
            out.flush();

            client.close();
        }
    }
}