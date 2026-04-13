import java.io.*;
import java.net.*;

public class java_02585_SocketServer_A01 {
    public static void main(String[] args) {
        int port = 8080; // default port
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            System.out.println("Server started on port " + port);
            Socket client = server.accept();
            System.out.println("Client connected");
            DataInputStream in = new DataInputStream(client.getInputStream());
            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            String message = in.readUTF();
            System.out.println("Received: " + message);
            out.writeUTF("Thank you for connecting to " + client.getRemoteSocketAddress());
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (server != null) server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}