import java.io.*;
import java.net.*;

public class java_28119_SocketServer_A03 {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(6666);
            System.out.println("Server is listening on port 6666...");
            
            while (true) {
                Socket client = server.accept();
                System.out.println("Client connected from: " + client.getRemoteSocketAddress());
                
                DataOutputStream out = new DataOutputStream(client.getOutputStream());
                out.writeUTF("Hello, client!");
                client.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}