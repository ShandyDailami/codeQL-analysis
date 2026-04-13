import java.net.*;
import java.io.*;

public class java_24293_SocketServer_A08 {

    public static void main(String[] args) {
        int port = 6000;
        ServerSocket server = null;

        try {
            server = new ServerSocket(port);
            System.out.println("Server started at port " + port);

            while (true) {
                Socket client = server.accept();
                System.out.println("Client connected");

                DataInputStream dis = new DataInputStream(client.getInputStream());
                DataOutputStream dos = new DataOutputStream(client.getOutputStream());

                String clientMessage = dis.readUTF();
                System.out.println("Received message from client: " + clientMessage);

                String serverMessage = "Hello, client";
                dos.writeUTF(serverMessage);
                System.out.println("Sent message to client: " + serverMessage);

                client.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}