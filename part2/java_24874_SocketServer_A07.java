import java.io.*;
import java.net.*;

public class java_24874_SocketServer_A07 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(4444);
            System.out.println("Server started on port 4444");

            while (true) {
                Socket socket = server.accept();
                System.out.println("A new client connected from " + socket.getRemoteSocketAddress());

                // For authentication failure, we'll just return a simple response
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                out.writeUTF("Connection successful");

                socket.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}