import java.io.*;
import java.net.*;

public class java_01009_SocketServer_A01 {
    private static int port = 9999;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(port);
            while (true) {
                Socket socket = server.accept();
                System.out.println("Accepted connection from " + socket.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String message = in.readUTF();
                System.out.println("Received message: " + message);

                out.writeUTF("Echo: " + message);
                out.flush();

                socket.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}