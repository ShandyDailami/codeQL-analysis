import java.io.*;
import java.net.*;
import java.util.*;

public class java_18300_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server started!");

        while (true) {
            Socket client = server.accept();
            System.out.println("Client connected!");

            DataInputStream dis = new DataInputStream(client.getInputStream());
            DataOutputStream dos = new DataOutputStream(client.getOutputStream());

            String clientMessage = dis.readUTF();
            System.out.println("Received: " + clientMessage);

            String response = "Thank you for connecting, " + clientMessage;
            dos.writeUTF(response);

            client.close();
        }
    }
}