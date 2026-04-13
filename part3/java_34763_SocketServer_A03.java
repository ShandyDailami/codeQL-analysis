import java.net.*;
import java.io.*;

public class java_34763_SocketServer_A03 {

    public static void main(String args[]) {
        try {
            ServerSocket server = new ServerSocket(8080);
            System.out.println("Waiting for client on port 8080...");

            while (true) {
                Socket client = server.accept();
                System.out.println("Connection accepted from " + client.getRemoteSocketAddress());

                DataInputStream dis = new DataInputStream(client.getInputStream());
                DataOutputStream dos = new DataOutputStream(client.getOutputStream());

                String message = dis.readUTF();
                System.out.println("Received: " + message);

                dos.writeUTF("Message received: " + message);
                dos.flush();

                client.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}