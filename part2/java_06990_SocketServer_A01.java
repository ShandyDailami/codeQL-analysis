import java.io.*;
import java.net.*;

public class java_06990_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);
        while(true) {
            Socket client = server.accept();
            System.out.println("A new client is connected");

            DataInputStream dis = new DataInputStream(client.getInputStream());
            DataOutputStream dos = new DataOutputStream(client.getOutputStream());

            // Reading from client
            String message = dis.readUTF();
            System.out.println("Received: " + message);

            // Sending message back to client
            dos.writeUTF("Message received, thank you!");
            dos.flush();

            client.close();
        }
    }
}