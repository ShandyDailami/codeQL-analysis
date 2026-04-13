import java.io.*;
import java.net.*;

public class java_17519_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8080);
            System.out.println("Server started on port 8080");

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected from " + socket.getRemoteSocketAddress());

                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                out.writeUTF("Hello client, you connected to the server!");
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}