import java.io.*;
import java.net.*;
import java.util.*;

public class java_21154_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8189);
        System.out.println("Server started at " + new Date());

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String message = dis.readUTF();
            System.out.println("Received: " + message);

            message = "Hello client, message received";
            dos.writeUTF(message);
            System.out.println("Sent: " + message);

            socket.close();
        }
    }
}