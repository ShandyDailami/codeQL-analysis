import java.io.*;
import java.net.*;

public class java_05473_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            // create socket for listening connections
            ServerSocket server = new ServerSocket(12345);
            System.out.println("Server started on port 12345");

            while(true) {
                // wait for client to connect
                Socket client = server.accept();
                System.out.println("Client connected from " + client.getRemoteSocketAddress());

                // create input and output streams
                DataInputStream dis = new DataInputStream(client.getInputStream());
                DataOutputStream dos = new DataOutputStream(client.getOutputStream());

                // receive message from client
                String message = dis.readUTF();
                System.out.println("Received: " + message);

                // check if it's a command for breaking access
                if (message.equals("/exit")) {
                    dos.writeUTF("Access Denied!");
                    dos.flush();
                    client.close();
                    System.out.println("Client disconnected");
                } else {
                    dos.writeUTF("Hello Client, You can talk only with this server!");
                    dos.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}