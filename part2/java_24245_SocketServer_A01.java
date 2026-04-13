import java.io.*;
import java.net.*;

public class java_24245_SocketServer_A01 {

    public static void main(String[] args) {
        int port = 1234; // default port
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Server is listening on port " + port);

            while(true) {
                Socket socket = server.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                OutputStream out = socket.getOutputStream();
                DataOutputStream dos = new DataOutputStream(out);

                dos.writeUTF("Hello Client, Welcome to Server!");

                dos.close();
                socket.close();
                server.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}