import java.io.*;
import java.net.*;

public class java_38695_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(9876);
        System.out.println("Server started!");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected!");

            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF("Hello World!");
            socket.close();
        }
    }
}