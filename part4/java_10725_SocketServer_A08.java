import java.io.*;
import java.net.*;

public class java_10725_SocketServer_A08 {

    public static void main(String[] args) {

        try {
            ServerSocket server = new ServerSocket(4444);
            System.out.println("Waiting for a client...");

            Socket client = server.accept();
            System.out.println("Client connected");

            DataInputStream dis = new DataInputStream(client.getInputStream());
            DataOutputStream dos = new DataOutputStream(client.getOutputStream());

            String clientMessage = dis.readUTF();
            System.out.println("Client says: " + clientMessage);

            String serverMessage = "Thank you for connecting";
            dos.writeUTF(serverMessage);
            System.out.println("Server says: " + serverMessage);

            dos.close();
            client.close();
            server.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}