import java.io.*;
import java.net.*;

public class java_10349_SocketServer_A08 {
    public static void main(String[] args) {
        int port = 6000;
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            System.out.println("Server is listening on port: " + port);
            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected: " + socket.getInetAddress().getHostAddress());

                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                String message = dis.readUTF();
                System.out.println("Received: " + message);
                dos.writeUTF(message);
                dos.flush();
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}