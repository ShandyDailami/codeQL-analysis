import java.io.*;
import java.net.*;

public class java_10827_SocketServer_A01 {
    public static void main(String[] args) {
        int port = 8080; // Default port
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        }
        try {
            ServerSocket server = new ServerSocket(port);
            while (true) {
                Socket client = server.accept();
                DataInputStream in = new DataInputStream(client.getInputStream());
                DataOutputStream out = new DataOutputStream(client.getOutputStream());
                String message = in.readUTF();
                out.writeUTF("Message received: " + message);
                client.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}