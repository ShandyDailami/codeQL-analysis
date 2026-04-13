import java.io.*;
import java.net.*;

public class java_21919_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(12345);
            System.out.println("Server started at " + server.getLocalSocketAddress());

            while (true) {
                Socket socket = server.accept();
                System.out.println("New connection accepted from " + socket.getRemoteSocketAddress());

                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                out.writeUTF("Connection established");

                socket.close();
           .
                }
            server.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}