import java.net.*;
import java.io.*;

public class java_01103_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(6000);
            System.out.println("Waiting for connection...");
            Socket client = server.accept();
            System.out.println("Connected!");

            DataInputStream dis = new DataInputStream(client.getInputStream());
            DataOutputStream dos = new DataOutputStream(client.getOutputStream());

            String message;
            while ((message = dis.readUTF()) != null) {
                System.out.println("Received: " + message);
                if (message.equalsIgnoreCase("exit")) {
                    System.out.println("Exiting...");
                    break;
                }

                // Sending back message to client
                dos.writeUTF("Message received: " + message);
                dos.flush();
            }
            client.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}