import java.io.*;
import java.net.*;
import java.util.*;

public class java_19387_SocketServer_A07 {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(6000);
            while (true) {
                Socket client = server.accept();
                System.out.println("Client connected from: " + client.getRemoteSocketAddress());

                DataOutputStream out = new DataOutputStream(client.getOutputStream());
                out.writeUTF("Connected to the server");

                DataInputStream in = new DataInputStream(client.getInputStream());
                String message = in.readUTF();
                System.out.println("Client says: " + message);

                client.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}