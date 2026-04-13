import java.io.*;
import java.net.*;

public class java_18948_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(6666);
            System.out.println("Waiting for a client...");

            Socket client = server.accept(); // block until a client connects

            System.out.println("Connection established with " + client.getInetAddress().getHostAddress());

            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            out.writeUTF("Connection established!");

            server.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}