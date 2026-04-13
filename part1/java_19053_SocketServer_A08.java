import java.io.*;
import java.net.*;

public class java_19053_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(6000);
            System.out.println("Waiting for a client...");

            Socket client = server.accept();
            System.out.println("Client connected!");

            DataInputStream in = new DataInputStream(client.getInputStream());
            DataOutputStream out = new DataOutputStream(client.getOutputStream());

            String message = in.readUTF();
            System.out.println("Message received: " + message);

            out.writeUTF("Thank you for connecting to " + client.getRemoteSocketAddress());
            System.out.println("Message sent: " + "Thank you for connecting to " + client.getRemoteSocketAddress());

            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}