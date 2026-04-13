import java.io.*;
import java.net.*;

public class java_25391_SocketServer_A07 {
    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;

        try {
            server = new ServerSocket(5000);
            System.out.println("Server started on port 5000");

            while (true) {
                socket = server.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                String message = "Hello Client, you are authenticated!";
                out.writeUTF(message);
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (server != null) {
                    server.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}