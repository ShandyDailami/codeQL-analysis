import java.io.*;
import java.net.*;
import java.util.*;

public class java_28387_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8189);
        System.out.println("Server started...");

        while (true) {
            Socket socket = server.accept();
            System.out.println("New client connected: " + socket.getRemoteSocketAddress());

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String message = dis.readUTF();
            System.out.println("Received message: " + message);

            if ("exit".equals(message)) {
                break;
            }

            dos.writeUTF("Thank you for connecting to server.");
            dos.flush();
        }

        server.close();
    }
}