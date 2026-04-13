import java.io.*;
import java.net.*;

public class java_32721_SocketServer_A07 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(4444);
            System.out.println("Server started on port 4444");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                out.writeUTF("Connection Successful");

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}